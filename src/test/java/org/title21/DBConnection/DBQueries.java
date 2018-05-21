package org.title21.DBConnection;

public class DBQueries
{
	public final String sessessiontimeoutinminutes="select sessiontimeoutinminutes from tbloptionsettingsPublic";
	public final String moveDocsOnReleaseDate="exec usp_DocumentsMoveDocsOnReleaseDate";
	public final String failedloginattempts="select NumFailedLoginAttempts from tbloptionsettingsPublic";
	public final String cibmtrValue="select CibmtrEnabled from tblOptionSettingsPublic";
	public final String cibmtrEnable="update tblOptionSettingsPublic set CibmtrEnabled=1 where AutoNumber=2";
	public final String lmsValue="select LmsEnabled from tblOptionSettingsPublic";
	public final String lmsEnable="update tblOptionSettingsPublic set LmsEnabled=1 where AutoNumber=2";
	public final String allowCibmtrAccessValue="select AllowCibmtrAccess from tblGroups where Groups=";
	public final String allowLMSAccessValue="select AllowLmsAccess from tblGroups where Groups=";
	public final String allowCibmtrAccessEnable="update tblGroups set AllowCibmtrAccess=1 where Groups=";
	public final String allowLMSAccessEnable="update tblGroups set AllowLmsAccess=1 where Groups=";
	public final String disablePermissionProhibitUserAttachingArchivedDoc="update tblOptionSettingsPublic set WarnUserOnAttachingArchivedDoc = 0 where AutoNumber=2";
	public final String disablePermissionProhibitUserAttachingReleasedDoc="update tblOptionSettingsPublic set WarnUserOnAttachingReleasedDoc = 0 where AutoNumber=2";
	public final String enablePermissionProhibitUserAttachingArchivedDoc="update tblOptionSettingsPublic set WarnUserOnAttachingArchivedDoc = 1 where AutoNumber=2";
	public final String enablePermissionProhibitUserAttachingReleasedDoc="update tblOptionSettingsPublic set WarnUserOnAttachingReleasedDoc = 1 where AutoNumber=2";
	public final String doNotForwardAttachedIndexCards="update tblProcessSteps set DoNotForwardAttachedIndexCards = 1  where ProcessStep='DCO in Progress' AND process='Open DCOs'";	
	public final String DCOsValue="select DoNotForwardAttachedIndexCards from tblProcessSteps where ProcessStep='DCO in Progress' AND process='Open DCOs'";
	public final String DeleteEbinder="DELETE FROM [dbo].[tblOrganizers] WHERE OrgName='eBinder Test'";
	public final String PromoteindexCards ="update tblOptionSettingsPublic set PromoteAllIndexCardsAtOnce = '0'";
	public final String AttachingApprovedDoc ="update tblOptionSettingsPublic set WarnUserOnAttachingApprovedDoc = 0 where AutoNumber=2";
	
	public final String setAdminPassword="update tblUserName set Password='C7EDEC18713D181102A641843B6B4738' where UserName='Admin'";
	
	public final String verifyTitle21User1="select UserName from tblUserName where Username='Title21User1'";
	public final String verifyTitle21User2="select UserName from tblUserName where Username='Title21User2'";
	public final String verifyTitle21User3="select UserName from tblUserName where Username='Title21User3'";
	public final String verifyTitle21User4="select UserName from tblUserName where Username='Title21User4'";
	public final String verifyTitle21User5="select UserName from tblUserName where Username='Title21User5'";
	
}
