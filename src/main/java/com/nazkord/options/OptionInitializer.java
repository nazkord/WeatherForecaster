package com.nazkord.options;

import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;

public class OptionInitializer {

    public static Options initialize() {
        Options options = new Options();
        OptionGroup optionGroup = new OptionGroup();
        optionGroup.addOption(CityOption.createCityOption());
        optionGroup.addOption(ParameterOption.createInfoParameterOption());
        optionGroup.addOption(UVOption.createUVOption());
        optionGroup.addOption(AverageOption.createAverageParameterOption());
        optionGroup.addOption(RectangleZoneOption.createRectangleZoneOption());
        optionGroup.addOption(DiagramOption.createDiagramOption());
        optionGroup.setRequired(true);
        options.addOptionGroup(optionGroup);
        return options;
    }


}
