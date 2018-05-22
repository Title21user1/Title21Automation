package org.title21.DBConnection;

public class SetApproverSignature 
{
	
	public final String setApproverTitle21User1=
			"exec sp_executesql N'INSERT [dbo].[tblDocApprovalRoleMembers]([Firm], [EventType], [Role], [Member])"
+"VALUES (@0, @1, @2, @3)"
+"',N'@0 nvarchar(50),@1 nvarchar(50),@2 nvarchar(50),@3 nvarchar(50)',@0=N'Synergen Life Sciences',@1=N'IndxCard',@2=N'Approver',@3=N'Title21User1'";

	
	public final String setApproverTitle21User2=
			"exec sp_executesql N'INSERT [dbo].[tblDocApprovalRoleMembers]([Firm], [EventType], [Role], [Member])"
+"VALUES (@0, @1, @2, @3)"
+"',N'@0 nvarchar(50),@1 nvarchar(50),@2 nvarchar(50),@3 nvarchar(50)',@0=N'Synergen Life Sciences',@1=N'IndxCard',@2=N'Approver',@3=N'Title21User2'";
	
	
	public final String setApproverTitle21User3=
			"exec sp_executesql N'INSERT [dbo].[tblDocApprovalRoleMembers]([Firm], [EventType], [Role], [Member])"
+"VALUES (@0, @1, @2, @3)"
+"',N'@0 nvarchar(50),@1 nvarchar(50),@2 nvarchar(50),@3 nvarchar(50)',@0=N'Synergen Life Sciences',@1=N'IndxCard',@2=N'Approver',@3=N'Title21User3'";
	
	
	public final String setApproverTitle21User4=
			"exec sp_executesql N'INSERT [dbo].[tblDocApprovalRoleMembers]([Firm], [EventType], [Role], [Member])"
+"VALUES (@0, @1, @2, @3)"
+"',N'@0 nvarchar(50),@1 nvarchar(50),@2 nvarchar(50),@3 nvarchar(50)',@0=N'Synergen Life Sciences',@1=N'IndxCard',@2=N'Approver',@3=N'Title21User4'";
	
	
	public final String setApproverTitle21User5=
			"exec sp_executesql N'INSERT [dbo].[tblDocApprovalRoleMembers]([Firm], [EventType], [Role], [Member])"
+"VALUES (@0, @1, @2, @3)"
+"',N'@0 nvarchar(50),@1 nvarchar(50),@2 nvarchar(50),@3 nvarchar(50)',@0=N'Synergen Life Sciences',@1=N'IndxCard',@2=N'Approver',@3=N'Title21User5'";
	
	
	public final String SignatureRoute_1=
			"exec sp_executesql N'INSERT [dbo].[tblDocRoutes]([Firm], [DocRouteName], [ReviewerByTitleOrName], [DocAuthor], [DocAuthorAllottedDays], [DocAuthorAllottedDaysText], [DocAuthorSupv], [DocAuthorSupvAllottedDays], [DocAuthorSupvAllottedDaysText], [AvailableInRunTime], [IsDocRoute], [Location], [UserMayModifyProfileOnApplication])"
+"VALUES (@0, @1, @2, @3, NULL, NULL, @4, NULL, NULL, @5, @6, @7, NULL)"
+"',N'@0 nvarchar(50),@1 nvarchar(50),@2 bit,@3 bit,@4 bit,@5 bit,@6 bit,@7 nvarchar(max) ',@0=N'Synergen Life Sciences',@1=N'Title21Route',@2=0,@3=0,@4=0,@5=0,@6=1,@7=N'Antioch'";
	
	
	public final String SignatureRoute_2=
			"exec sp_executesql N'INSERT [dbo].[tblDocRouteDesignPermissions]([Firm], [DocRouteName], [Groups])"
+"VALUES (@0, @1, @2)"
+"',N'@0 nvarchar(50),@1 nvarchar(50),@2 nvarchar(128)',@0=N'Synergen Life Sciences',@1=N'Title21Route',@2=N'Administrators'";
	
	
	public final String SignatureRoute_3=
			"exec sp_executesql N'INSERT [dbo].[tblDocRouteReviewers]([TempID], [Firm], [DocRouteName], [DocReviewer], [Sequence], [Role], [AllottedDays], [AllottedDaysText], [DocReviewerDept], [DocReviewerTitle])"
+"VALUES (@0, @1, @2, @3, @4, @5, @6, @7, NULL, NULL)"
+"SELECT [AutoID]"
+"FROM [dbo].[tblDocRouteReviewers]"
+"WHERE @@ROWCOUNT > 0 AND [AutoID] = scope_identity()',N'@0 nvarchar(10),@1 nvarchar(50),@2 nvarchar(50),@3 nvarchar(50),@4 tinyint,@5 nvarchar(50),@6 int,@7 nvarchar(50)',@0=N'AddNew1',@1=N'Synergen Life Sciences',@2=N'Title21Route',@3=N'Title21User5',@4=2,@5=N'Approver',@6=1,@7=N'1 day'";
	
}
	
	
