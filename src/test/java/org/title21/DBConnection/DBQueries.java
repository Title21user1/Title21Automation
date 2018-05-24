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
	public final String uncheckWizardPopUp="update tblOptionSettingsPrivate set OpenWizardOnStartUp=0";
	
	public final String verifyTitle21User1="select UserName from tblUserName where Username='Title21User1'";
	public final String verifyTitle21User2="select UserName from tblUserName where Username='Title21User2'";
	public final String verifyTitle21User3="select UserName from tblUserName where Username='Title21User3'";
	public final String verifyTitle21User4="select UserName from tblUserName where Username='Title21User4'";
	public final String verifyTitle21User5="select UserName from tblUserName where Username='Title21User5'";
	public final String verifyTitle21Group="SELECT Groups FROM tblGroups WHERE Groups='Title21Group'";
	
	public final String addCodeClass="exec sp_executesql N'INSERT [dbo].[tblCodeClass]([CodeClass]) VALUES (@0)',N'@0 nvarchar(128)',@0=N'Title21 Code Class'";
	public final String addCodeCategory="exec sp_executesql N'exec usp_WebAddCodeCategory @p0, @p1',N'@p0 nvarchar(18),@p1 nvarchar(21)',@p0=N'Title21 Code Class',@p1=N'Title21 Code Category'";
	public final String addCode="exec sp_executesql N'exec usp_WebAddCode @p0, @p1,@p2,@p3,@p4,@p5',N'@p0 nvarchar(18),@p1 nvarchar(21),@p2 nvarchar(12),@p3 nvarchar(4),@p4 nvarchar(9),@p5 int',@p0=N'Title21 Code Class',@p1=N'Title21 Code Category',@p2=N'Title21 Code',@p3=N'4567',@p4=N'Define',@p5=1";
	
}
