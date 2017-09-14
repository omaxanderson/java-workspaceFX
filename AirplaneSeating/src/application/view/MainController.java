package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class MainController {

	@FXML
	private Button selectSeatButton;
	/*
	@FXML
	private Label zeroZero;
	@FXML
	private Label zeroOne;
	@FXML
	private Label zeroTwo;
	@FXML
	private Label zeroThree;
	@FXML
	private Label zeroFour;
	@FXML
	private Label zeroFive;
	@FXML
	private Label zeroSix;
	@FXML
	private Label zeroSeven;
	@FXML
	private Label zeroEight;
	@FXML
	private Label zeroNine;
	@FXML
	private Label zeroTen;
	@FXML
	private Label zeroEleven;
	@FXML
	private Label zeroTwelve;
	@FXML
	private Label zeroThirteen;
	@FXML
	private Label oneZero;
	@FXML
	private Label oneTwo;
	@FXML
	private Label oneThree;
	@FXML
	private Label oneFour;
	@FXML
	private Label oneFive;
	@FXML
	private Label oneSix;
	@FXML
	private Label oneSeven;
	@FXML
	private Label oneEight;
	@FXML
	private Label oneNine;
	@FXML
	private Label oneTen;
	@FXML
	private Label oneEleven;
	@FXML
	private Label oneTwelve;
	@FXML
	private Label oneThirteen;
	@FXML
	private Label twoZero;
	@FXML
	private Label twoOne;
	@FXML
	private Label twoTwo;
	@FXML
	private Label twoThree;
	@FXML
	private Label twoFour;
	@FXML
	private Label twoFive;
	@FXML
	private Label twoSix;
	@FXML
	private Label twoSeven;
	@FXML
	private Label twoEight;
	@FXML
	private Label twoNine;
	@FXML
	private Label twoTen;
	@FXML
	private Label twoEleven;
	@FXML
	private Label twoTwelve;
	@FXML
	private Label twoThirteen;
	@FXML
	private Label threeZero;
	@FXML
	private Label threeOne;
	@FXML
	private Label threeTwo;
	@FXML
	private Label threeThree;
	@FXML
	private Label threeFour;
	@FXML
	private Label threeFive;
	@FXML
	private Label threeSix;
	@FXML
	private Label threeSeven;
	@FXML
	private Label threeEight;
	@FXML
	private Label threeNine;
	@FXML
	private Label threeTen;
	@FXML
	private Label threeEleven;
	@FXML
	private Label threeTwelve;
	@FXML
	private Label threeThirteen;
	@FXML
	private Label fourZero;
	@FXML
	private Label fourOne;
	@FXML
	private Label fourTwo;
	@FXML
	private Label fourThree;
	@FXML
	private Label fourFour;
	@FXML
	private Label fourFive;
	@FXML
	private Label fourSix;
	@FXML
	private Label fourSeven;
	@FXML
	private Label fourEight;
	@FXML
	private Label fourNine;
	@FXML
	private Label fourTen;
	@FXML
	private Label fourEleven;
	@FXML
	private Label fourTwelve;
	@FXML
	private Label fourThirteen;
	@FXML
	private Label fiveZero;
	@FXML
	private Label fiveOne;
	@FXML
	private Label fiveTwo;
	@FXML
	private Label fiveThree;
	@FXML
	private Label fiveFour;
	@FXML
	private Label fiveFive;
	@FXML
	private Label fiveSix;
	@FXML
	private Label fiveSeven;
	@FXML
	private Label fiveEight;
	@FXML
	private Label fiveNine;
	@FXML
	private Label fiveTen;
	@FXML
	private Label fiveEleven;
	@FXML
	private Label fiveTwelve;
	@FXML
	private Label fiveThirteen;
	*/
	
	@FXML
	private RadioButton zeroZeroB;
	@FXML
	private RadioButton zeroOneB;
	@FXML
	private RadioButton zeroTwoB;
	@FXML
	private RadioButton zeroThreeB;
	@FXML
	private RadioButton zeroFourB;
	@FXML
	private RadioButton zeroFiveB;
	@FXML
	private RadioButton zeroSixB;
	@FXML
	private RadioButton zeroSevenB;
	@FXML
	private RadioButton zeroEightB;
	@FXML
	private RadioButton zeroNineB;
	@FXML
	private RadioButton zeroTenB;
	@FXML
	private RadioButton zeroElevenB;
	@FXML
	private RadioButton zeroTwelveB;
	@FXML
	private RadioButton zeroThirteenB;
	@FXML
	private RadioButton oneZeroB;
	@FXML
	private RadioButton oneTwoB;
	@FXML
	private RadioButton oneThreeB;
	@FXML
	private RadioButton oneFourB;
	@FXML
	private RadioButton oneFiveB;
	@FXML
	private RadioButton oneSixB;
	@FXML
	private RadioButton oneSevenB;
	@FXML
	private RadioButton oneEightB;
	@FXML
	private RadioButton oneNineB;
	@FXML
	private RadioButton oneTenB;
	@FXML
	private RadioButton oneElevenB;
	@FXML
	private RadioButton oneTwelveB;
	@FXML
	private RadioButton oneThirteenB;
	@FXML
	private RadioButton twoZeroB;
	@FXML
	private RadioButton twoOneB;
	@FXML
	private RadioButton twoTwoB;
	@FXML
	private RadioButton twoThreeB;
	@FXML
	private RadioButton twoFourB;
	@FXML
	private RadioButton twoFiveB;
	@FXML
	private RadioButton twoSixB;
	@FXML
	private RadioButton twoSevenB;
	@FXML
	private RadioButton twoEightB;
	@FXML
	private RadioButton twoNineB;
	@FXML
	private RadioButton twoTenB;
	@FXML
	private RadioButton twoElevenB;
	@FXML
	private RadioButton twoTwelveB;
	@FXML
	private RadioButton twoThirteenB;
	@FXML
	private RadioButton threeZeroB;
	@FXML
	private RadioButton threeOneB;
	@FXML
	private RadioButton threeTwoB;
	@FXML
	private RadioButton threeThreeB;
	@FXML
	private RadioButton threeFourB;
	@FXML
	private RadioButton threeFiveB;
	@FXML
	private RadioButton threeSixB;
	@FXML
	private RadioButton threeSevenB;
	@FXML
	private RadioButton threeEightB;
	@FXML
	private RadioButton threeNineB;
	@FXML
	private RadioButton threeTenB;
	@FXML
	private RadioButton threeElevenB;
	@FXML
	private RadioButton threeTwelveB;
	@FXML
	private RadioButton threeThirteenB;
	@FXML
	private RadioButton fourZeroB;
	@FXML
	private RadioButton fourOneB;
	@FXML
	private RadioButton fourTwoB;
	@FXML
	private RadioButton fourThreeB;
	@FXML
	private RadioButton fourFourB;
	@FXML
	private RadioButton fourFiveB;
	@FXML
	private RadioButton fourSixB;
	@FXML
	private RadioButton fourSevenB;
	@FXML
	private RadioButton fourEightB;
	@FXML
	private RadioButton fourNineB;
	@FXML
	private RadioButton fourTenB;
	@FXML
	private RadioButton fourElevenB;
	@FXML
	private RadioButton fourTwelveB;
	@FXML
	private RadioButton fourThirteenB;
	@FXML
	private RadioButton fiveZeroB;
	@FXML
	private RadioButton fiveOneB;
	@FXML
	private RadioButton fiveTwoB;
	@FXML
	private RadioButton fiveThreeB;
	@FXML
	private RadioButton fiveFourB;
	@FXML
	private RadioButton fiveFiveB;
	@FXML
	private RadioButton fiveSixB;
	@FXML
	private RadioButton fiveSevenB;
	@FXML
	private RadioButton fiveEightB;
	@FXML
	private RadioButton fiveNineB;
	@FXML
	private RadioButton fiveTenB;
	@FXML
	private RadioButton fiveElevenB;
	@FXML
	private RadioButton fiveTwelveB;
	@FXML
	private RadioButton fiveThirteenB;
	
	
	
	
	
}
