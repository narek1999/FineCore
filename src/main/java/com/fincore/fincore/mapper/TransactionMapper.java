package com.fincore.fincore.mapper;

import com.fincore.fincore.dto.CreateTransactionRequest;
import com.fincore.fincore.dto.TransactionResponse;
import com.fincore.fincore.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface TransactionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Transaction toEntity(CreateTransactionRequest request);

    TransactionResponse toResponse(Transaction transaction);
}