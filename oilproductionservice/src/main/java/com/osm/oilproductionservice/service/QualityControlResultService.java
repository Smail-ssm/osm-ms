package com.osm.oilproductionservice.service;

import com.osm.oilproductionservice.dto.QualityControlResultDto;
import com.osm.oilproductionservice.dto.QualityControlRuleDto;
import com.osm.oilproductionservice.dto.UnifiedDeliveryDTO;
import com.osm.oilproductionservice.enums.RuleType;
import com.osm.oilproductionservice.model.QualityControlResult;
import com.osm.oilproductionservice.model.QualityControlRule;
import com.osm.oilproductionservice.model.UnifiedDelivery;
import com.osm.oilproductionservice.repository.QualityControlResultRepository;
import com.osm.oilproductionservice.repository.QualityControlRuleRepository;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class QualityControlResultService extends BaseServiceImpl<QualityControlResult, QualityControlResultDto, QualityControlResultDto> {

    private static final Logger log = LoggerFactory.getLogger(QualityControlResultService.class);

    @Autowired
    private final QualityControlResultRepository repository;

    @Autowired
    private final QualityControlRuleRepository ruleRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final UnifiedDeliveryService unifiedDeliveryService;

    protected QualityControlResultService(BaseRepository<QualityControlResult> repository, ModelMapper modelMapper, QualityControlResultRepository repository1, QualityControlRuleRepository ruleRepository, ModelMapper modelMapper1, UnifiedDeliveryService unifiedDeliveryService) {
        super(repository, modelMapper);
        this.repository = repository1;
        this.ruleRepository = ruleRepository;
        this.modelMapper = modelMapper1;
        this.unifiedDeliveryService = unifiedDeliveryService;
    }

    @Transactional
    public List<QualityControlResultDto> saveAll(List<QualityControlResultDto> dtos) {
        log.debug("Processing saveAll for {} DTOs", dtos.size());
        List<QualityControlResult> entities = dtos.stream().map(dto -> {
            log.debug("Mapping DTO: {}", dto);
            QualityControlResult entity = new QualityControlResult();

            // Set measured value
            if (RuleType.NUMERIC.equals(dto.getRule().getRuleType())) {
                try {
                    Double.parseDouble(dto.getMeasuredValue());
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid numeric value for rule: " + dto.getRule().getId());
                }
            } else if (RuleType.BOOLEAN.equals(dto.getRule().getRuleType())) {
                if (!"true".equalsIgnoreCase(dto.getMeasuredValue()) && !"false".equalsIgnoreCase(dto.getMeasuredValue())) {
                    throw new IllegalArgumentException("Invalid boolean value for rule: " + dto.getRule().getId());
                }
            } else {
                throw new IllegalArgumentException("Invalid rule type: " + dto.getRule().getRuleType());
            }
            entity.setMeasuredValue(dto.getMeasuredValue());
            // Handle rule
            QualityControlRuleDto rulID = dto.getRule();
            if (rulID != null) {
                QualityControlRule rule = ruleRepository.findById(rulID.getId())
                        .orElseThrow(() -> {
                            log.error("Rule not found for ID: {}", rulID);
                            return new IllegalArgumentException("Rule not found for ID: " + rulID);
                        });
                entity.setRule(rule);
            } else {
                log.error("Rule is required for QualityControlResult");
                throw new IllegalArgumentException("Rule is required for QualityControlResult");
            }

            // Handle delivery
            UnifiedDeliveryDTO deliveryEntity = dto.getDelivery();
            if (deliveryEntity != null) {
                UnifiedDeliveryDTO deliveryDto = unifiedDeliveryService.findById(deliveryEntity.getId());
                if (deliveryDto == null) {
                    log.error("Delivery not found for ID: {}", deliveryEntity);
                    throw new IllegalArgumentException("Delivery not found for ID: " + deliveryEntity);
                }
                UnifiedDelivery delivery = modelMapper.map(deliveryDto, UnifiedDelivery.class);
                entity.setDelivery(delivery);
            } else {
                log.error("Delivery is required for QualityControlResult");
                throw new IllegalArgumentException("Delivery is required for QualityControlResult");
            }

            return entity;
        }).collect(Collectors.toList());

        log.debug("Saving {} entities", entities.size());
        List<QualityControlResult> savedEntities = repository.saveAll(entities);
        log.debug("Mapping {} saved entities to DTOs", savedEntities.size());
        return savedEntities.stream()
                .map(entity -> modelMapper.map(entity, QualityControlResultDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<QualityControlResultDto> findAll() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Transactional(readOnly = true)
    public List<QualityControlResultDto> findByDeliveryId(UUID deliveryId) {
        log.debug("Fetching quality control results for deliveryId: {}", deliveryId);
        if (deliveryId == null) {
            log.error("Delivery ID is null");
            throw new IllegalArgumentException("Delivery ID is required");
        }

        List<QualityControlResult> results = repository.findByDeliveryId(deliveryId);
        log.debug("Found {} quality control results for deliveryId: {}", results.size(), deliveryId);

        return results.stream()
                .map(entity -> modelMapper.map(entity, QualityControlResultDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<QualityControlResultDto> updateAll(List<QualityControlResultDto> dtos) {
        log.debug("Processing updateAll for {} DTOs", dtos.size());
        List<QualityControlResult> entities = dtos.stream().map(dto -> {
            log.debug("Mapping DTO for update: {}", dto);

            // Ensure ID is present for updates
            if (dto.getId() == null) {
                log.error("ID is required for updating QualityControlResult");
                throw new IllegalArgumentException("ID is required for updating QualityControlResult");
            }

            // Fetch existing entity
            QualityControlResult entity = repository.findById(dto.getId())
                    .orElseThrow(() -> {
                        log.error("Quality control result not found for ID: {}", dto.getId());
                        return new IllegalArgumentException("Quality control result not found for ID: " + dto.getId());
                    });

            // Set measured value
            if (RuleType.NUMERIC.equals(dto.getRule().getRuleType())) {
                try {
                    Double.parseDouble(dto.getMeasuredValue());
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid numeric value for rule: " + dto.getRule().getId());
                }
            } else if (RuleType.BOOLEAN.equals(dto.getRule().getRuleType())) {
                if (!"true".equalsIgnoreCase(dto.getMeasuredValue()) && !"false".equalsIgnoreCase(dto.getMeasuredValue())) {
                    throw new IllegalArgumentException("Invalid boolean value for rule: " + dto.getRule().getId());
                }
            } else {
                throw new IllegalArgumentException("Invalid rule type: " + dto.getRule().getRuleType());
            }
            entity.setMeasuredValue(dto.getMeasuredValue());

            // Handle rule
            QualityControlRuleDto ruleDto = dto.getRule();
            if (ruleDto != null) {
                QualityControlRule rule = ruleRepository.findById(ruleDto.getId())
                        .orElseThrow(() -> {
                            log.error("Rule not found for ID: {}", ruleDto.getId());
                            return new IllegalArgumentException("Rule not found for ID: " + ruleDto.getId());
                        });
                entity.setRule(rule);
            } else {
                log.error("Rule is required for QualityControlResult");
                throw new IllegalArgumentException("Rule is required for QualityControlResult");
            }

            // Handle delivery
            UnifiedDeliveryDTO deliveryDto = dto.getDelivery();
            if (deliveryDto != null) {
                UnifiedDeliveryDTO existingDelivery = unifiedDeliveryService.findById(deliveryDto.getId());
                if (existingDelivery == null) {
                    log.error("Delivery not found for ID: {}", deliveryDto.getId());
                    throw new IllegalArgumentException("Delivery not found for ID: " + deliveryDto.getId());
                }
                UnifiedDelivery delivery = modelMapper.map(existingDelivery, UnifiedDelivery.class);
                entity.setDelivery(delivery);
            } else {
                log.error("Delivery is required for QualityControlResult");
                throw new IllegalArgumentException("Delivery is required for QualityControlResult");
            }

            return entity;
        }).collect(Collectors.toList());

        log.debug("Updating {} entities", entities.size());
        List<QualityControlResult> updatedEntities = repository.saveAll(entities);
        log.debug("Mapping {} updated entities to DTOs", updatedEntities.size());
        return updatedEntities.stream()
                .map(entity -> modelMapper.map(entity, QualityControlResultDto.class))
                .collect(Collectors.toList());
    }
}