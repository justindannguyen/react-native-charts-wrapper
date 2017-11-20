import PropTypes from "prop-types";
import { requireNativeComponent, View } from "react-native";

import PieRadarChartBase from "./PieRadarChartBase";
import { pieData } from "./ChartDataConfig";

const centerTextIFace = {
  enabled: PropTypes.bool,
  text: PropTypes.string,
  textSize: PropTypes.number,
  textSizePixels: PropTypes.number,
  textOffsetX: PropTypes.number,
  textOffsetY: PropTypes.number,
  textColor: PropTypes.number,
  radiusPercent: PropTypes.number
};

const iface = {
  name: "PieChart",
  propTypes: {
    ...PieRadarChartBase.propTypes,

    drawEntryLabels: PropTypes.bool,
    usePercentValues: PropTypes.bool,

    centerText: PropTypes.string,
    centerTextRadiusPercent: PropTypes.number,
    holeRadius: PropTypes.number,
    holeColor: PropTypes.number,
    transparentCircleRadius: PropTypes.number,
    transparentCircleColor: PropTypes.number,

    entryLabelColor: PropTypes.number,
    entryLabelTextSize: PropTypes.number,
    maxAngle: PropTypes.number,

    // TODO PieChart should have only one dataset
    data: pieData
  }
};

export default requireNativeComponent("RNPieChart", iface, {
  nativeOnly: { onSelect: true }
});
