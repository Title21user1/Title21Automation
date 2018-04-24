package org.title21.validation.entities;

public class ErrorMessages 
{	
	public static final String messagewithoutUsername="The User Name field is required.";
	public static final String messagewithoutPassword="The Password field is required.";
	public static final String passworderrormessages = "Invalid credentials. Please try again or contact your System Administrator for assistance.";
	public static final String messageonLogoutAlert="Are you sure you want to log out?";
	public static final String groupnamealreadyexist ="This name already exists. Please enter another name.";
	public static final String locationValidationMessage="Location is required";
	public static final String fullNameValidationMessage="Full Name is required";
	public static final String employeeIDValidationMessage="Employee ID is required";	
	public static final String businessUnitValidationMessage="Bussiness Unit is required";
	public static final String departmentValidationMessage="Department is required";	
	public static final String createEmployeeSuccessMessage="added successfully!";
	public static final String employeeIDExistsValidationMessage="EmployeeID Already Exists";
	public static final String employeeNameExistsValidationMessage="Full Name already exists";
	public static final String EditEmployeeSuccessMessage="updated successfully!";

	// CreateDocumentModule
	public static final String DocumentTitleValidationMessage="Document Title is required.";
	public static final String DocumentSummaryValidationMessage="Document Change Summary is required.";
	public static final String AppendixValidationMessage="Please enter a Document Appendix";
	public static final String nameFieldValidationMessage="Name is required.";
	public static final String sequenceFieldValidationMessage="Sequence is required.";
	public static final String allottedDaysValidationMessage="Allotted days are required.";
	public static final String roleFieldValidationMessage="Role is required.";
	public static final String FileSizeuploadValidationMessage="File size must be less than 50 MB.";
	public static final String checkedsuccessfullyMessage="checked in successfully.";
	public static final String permissionToEdit="You don't have permissions to edit form";
	public static final String rejectedmessage="You have successfully rejected";
	public static final String recordLockeditmodevalidation="This record is locked";

	//Reports
	public static final String ReportNameValidation="Report name is required.";
	public static final String SelectReportValidation="Please select report.";
	public static final String CategoryRequiredValidation="Category is required.";
	public static final String DesignPermissionValidation="Please select at least one group with design permission.";
	public static final String ReportEditPermission="You must be a member of group with design permission to access this functionality.";

	//Periodic Review delegate
	public static final String NoResultFoundOnReviewValidation="No results returned, please check your filter.";

}
