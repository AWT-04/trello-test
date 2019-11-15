package org.fundacionjala.trello.runner;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellTransformer;
import org.fundacionjala.trello.pages.board.BoardFields;
import org.fundacionjala.trello.pages.team.TeamFields;

import java.util.Locale;

import static java.util.Locale.ENGLISH;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return ENGLISH;
    }

    @Override
    public void configureTypeRegistry(final TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(BoardFields.class,
                (TableCellTransformer<BoardFields>) cell -> BoardFields.valueOf(cell.toUpperCase())));
        typeRegistry.defineDataTableType(new DataTableType(TeamFields.class,
                (TableCellTransformer<TeamFields>) cell -> TeamFields.valueOf(cell.toUpperCase())));
    }
}
