package org.title21.DBConnection;

public class CabinetProperties 
{
	public final String CabinetProperties=
			"exec sp_executesql N'DELETE [dbo].[tblProcessStepsGroupsAllowedAccess]"
+"WHERE (((([Firm] = @0) AND ([Process] = @1)) AND ([ProcessStep] = @2)) AND ([Groups] = @3))',N'@0 nvarchar(50),@1 nvarchar(50),@2 nvarchar(50),@3 nvarchar(50)',@0=N'Synergen Life Sciences',@1=N'Draft',@2=N'Regulated',@3=N'Administrators'"


+"exec sp_executesql N'DELETE [dbo].[tblProcessStepsGroupsAllowedDesign]"
+"WHERE (((([Firm] = @0) AND ([Cabinet] = @1)) AND ([CabinetSection] = @2)) AND ([Groups] = @3))',N'@0 nvarchar(50),@1 nvarchar(50),@2 nvarchar(50),@3 nvarchar(50)',@0=N'Synergen Life Sciences',@1=N'Draft',@2=N'Regulated',@3=N'Administrators'"


+"exec sp_executesql N'INSERT [dbo].[tblProcessStepsGroupsAllowedAccess]([Firm], [Process], [ProcessStep], [Groups], [Permission])"
+"VALUES (@0, @1, @2, @3, @4)"
+"',N'@0 nvarchar(50),@1 nvarchar(50),@2 nvarchar(50),@3 nvarchar(50),@4 tinyint',@0=N'Synergen Life Sciences',@1=N'Draft',@2=N'Regulated',@3=N'Administrators',@4=2"


+"exec sp_executesql N'INSERT [dbo].[tblProcessStepsGroupsAllowedDesign]([Firm], [Cabinet], [CabinetSection], [Groups])"
+"VALUES (@0, @1, @2, @3)"
+"',N'@0 nvarchar(50),@1 nvarchar(50),@2 nvarchar(50),@3 nvarchar(50)',@0=N'Synergen Life Sciences',@1=N'Draft',@2=N'Regulated',@3=N'Administrators'";

}
