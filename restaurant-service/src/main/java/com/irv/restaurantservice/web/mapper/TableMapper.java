package com.irv.restaurantservice.web.mapper;

import com.irv.restaurantservice.domain.Table;
import com.irv.restaurantservice.web.model.TableDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TableMapper {
    Table tableDtoToTable(TableDto table);
    TableDto tableToTableDto(Table table);
    List<TableDto> tablesToTablesDto(List<Table> table);
    List<Table> tablesDtoToTables(List<TableDto> table);
}
