package testNG;

import org.testng.annotations.Test;

public class Topic_03_Priority {
  @Test(priority = 1) // In reality, should set the number in the name of the case to priority the cases
  public void EndUser_Register_New_Employee() {
	  
  }
  
  @Test(enabled = false) // for not running this case
  public void EndUser_View_Employee() {
	  
  }
  
  @Test(description = "Jira_0787 - Edit information of chosen employee") // can be used to attach into a TMS(test management system: jira, trello, ...)
  public void EndUser_Edit_Employee() {
	  
  }
  
  @Test
  public void EndUser_Move_Employee() {
	  
  }
  
}
