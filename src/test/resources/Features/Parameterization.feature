Feature: Study parameterization in cucumber

Scenario: Passingparameter from step
	Given I have 7 and 9 
	When I add them
	Then Verify if the result is prime
	
Scenario: Passing single parameter
	Given I have a number 67
	
Scenario: Passing String as a parameter
	Given I have a name "Pradnya"

@Smoke
Scenario: Passing data table as parameter
	Given I have <RTO_Codes>
	|MH|
	|GJ|
	|CH|
	|MP|
	|RJ|
	|GA|
	|TN|
	|DL|
	
@Regression 
Scenario: Passing data table as parameter
	Given I have <RTO_Codes> and <State_Name>
	|MH|Maharashtra|
	|GJ|Gujrat|
	|CH|Chhattisgarh|
	|MP|Madhya Pradesh|
	|RJ|Rajasthan|
	|GA|Goa|
	|TN|Temil Nadu|
	|DL|Delhi|
	
	
Scenario Outline: Data driven testcase demo
	Given I have a <RTO_Codes> and <State_Code>
	
Examples: 
	|RTO_Codes|State_Code|
	|MH|Maharashtra|
	|GJ|Gujrat|
	|CH|Chhattisgarh|
	|MP|MadhyaPradesh|
	|RJ|Rajasthan|
	|GA|Goa|
	|TN|TemilNadu|
	|DL|Delhi|
	
Scenario Outline: Verify all pincodes where Levis T-shirts cannot be shipped
	Given Enter Levis in search component
	When User click on Men solid thermal top'
	Then Switch to newly opened PIP
	When User enters <pincodes>
	Then Verify that error message appears
	
Examples:
	||
	
