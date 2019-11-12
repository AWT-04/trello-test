package org.fundacionjala.trello.runner;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellTransformer;
import io.cucumber.testng.CucumberOptions;
import org.fundacionjala.trello.pages.board.BoardFields;

import java.util.Locale;

import static java.util.Locale.ENGLISH;
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.fundacionjala.trello"}
)

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(BoardFields.class,
                (TableCellTransformer<BoardFields>) cell -> BoardFields.valueOf(cell.toUpperCase())));
    }
}
