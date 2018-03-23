package org.title21.DBConnection;

public class DBQueries
{
	public final String sessessiontimeoutinminutes="select sessiontimeoutinminutes from tbloptionsettingsPublic";
	public final String moveDocsOnReleaseDate="exec usp_DocumentsMoveDocsOnReleaseDate";
	public final String failedloginattempts="select NumFailedLoginAttempts from tbloptionsettingsPublic";
}
