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
	public final String allowCibmtrAccessValue="select Groups AllowCibmtrAccess from tblGroups where Groups=";
	public final String allowLMSAccessValue="select Groups AllowLmsAccess from tblGroups where Groups=";
	public final String allowCibmtrAccessEnable="update tblGroups set AllowCibmtrAccess=1 where Groups=";
	public final String allowLMSAccessEnable="update tblGroups set AllowLmsAccess=1 where Groups=";
}
