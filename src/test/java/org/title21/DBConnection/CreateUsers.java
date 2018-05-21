package org.title21.DBConnection;

public class CreateUsers
{
	public final String Title21User1_1=
			"exec sp_executesql N'INSERT [dbo].[tblEmployees]([EmployeeID], [Status], [FullName], [Address], [City], [State], [Postal Code], [Country], [Phone], [Email], [Modified], [SupervisorID], [DefaultFirm], [Department], [JobTitle], [HideName], [JobCode], [Location], [EmploymentType], [ForwardItemsTo], [HireDate], [AltEmployeeID])"
+"VALUES (@0, NULL, @1, NULL, NULL, NULL, NULL, NULL, NULL, @2, @3, @4, @5, @6, @7, @8, @9, @10, NULL, NULL, NULL, NULL)"
+"',N'@0 nvarchar(25),@1 nvarchar(50),@2 nvarchar(50),@3 datetime2(7),@4 nvarchar(50),@5 nvarchar(50),@6 nvarchar(50),@7 nvarchar(50),@8 bit,@9 nvarchar(50),@10 nvarchar(50)',@0=N'001',@1=N'Title21User1',@2=N'email@abc.com',@3='2018-05-10 02:57:09.2660772',@4=N'Admin',@5=N'Synergen Life Sciences',@6=N'Document Control',@7=N'Human Resources Clerk',@8=0,@9=N'001099',@10=N'Antioch'";

	public final String Title21User1_2=
			"exec sp_executesql N'INSERT [dbo].[tblTrainingAppliedJobCodes]([EmployeeID], [JobCode], [InJobCodeSince], [ExitJobCodeOn])"
+"VALUES (@0, @1, @2, NULL)"
+"',N'@0 nvarchar(25),@1 nvarchar(50),@2 datetime2(7)',@0=N'001',@1=N'001099',@2='2018-05-10 02:57:09.2817110'";

	public final String Title21User1_3=
			"exec sp_executesql N'INSERT [dbo].[tblUserName]([UserName], [FullName], [Password], [PIN], [PasswordExpiresEvery], [PasswordExpires], [Disabled], [ForcePswChange], [AuthenticationType], [BadLoginPswCount], [Lockout], [PasswordLastChangedOn], [IsSystemAdmin])"
+"VALUES (@0, @1, @2, NULL, NULL, @3, @4, @5, @6, NULL, @7, NULL, NULL)"
+"',N'@0 nvarchar(20),@1 nvarchar(50),@2 nvarchar(128),@3 datetime2(7),@4 bit,@5 bit,@6 tinyint,@7 bit',@0=N'Title21User1',@1=N'Title21User1',@2=N'73682633E3F3A892175E864A593C91F7',@3='2028-05-10 03:06:06.2661009',@4=0,@5=0,@6=1,@7=0";

	public final String Title21User1_4=
			"exec sp_executesql N'INSERT [dbo].[tblOptionSettingsPrivate]([UserID], [Modified], [EULAAccepted], [OnAddNewTaskSetMeToBeNotifiedOnCompletion], [OpenWizardOnStartUp], [TutorialMode], [TutorialModeHome], [TutorialModeTraining], [TutorialModeApproval], [TutorialModeReport], [TutorialModeFavorite], [TutorialModeSearch], [TutorialModeOrganizer], [TutorialModeReview], [DisplayDocHardCopy], [TutorialModePopUp], [TutorialModeChart], [BatchReview], [AutoLoad], [AutoScroll], [PaginationPageSize], [CanSignWithoutReading], [AlterChartPermissions], [OpenDocOnCheckOut], [DocCheckOutIncludeAttachments], [DocCheckOutIncludeDocumentReviewers], [DocCheckOutIncludeTrainingItems], [TaskRequiresESig], [TaskEnableOnAdd], [TaskEmailOnAddNew], [TaskIsDocCollaborationTask], [MyTasksFilterDefaultDay], [MyTasksFilterActionStatusOpen], [MyTasksFilterTaskStatus], [MyDocsVersion], [MyDocsDefaultDay], [MyDocsCabinet], [ViewMode], [MyDocsNcTasksFilterDefaultDay], [MyDocsNcTasksFilterActionStatusOpen], [MyDocsNcTasksFilterTaskStatus], [MyDocsTasksFilterDefaultDay], [MyDocsTasksFilterActionStatusOpen], [MyDocsTasksFilterTaskStatus], [MruListCount], [DefaultLandingPage], [CanCreateCibmtrForm])"
+"VALUES (@0, @1, NULL, NULL, @2, @3, @4, @5, @6, @7, @8, @9, @10, @11, @12, @13, @14, @15, @16, @17, NULL, @18, @19, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, @20, @21, @22, @23, NULL, NULL, @24, @25, @26, @27, @28, @29, @30, NULL, @31, @32)"
+"',N'@0 nvarchar(20),@1 datetime2(7),@2 bit,@3 bit,@4 bit,@5 bit,@6 bit,@7 bit,@8 bit,@9 bit,@10 bit,@11 bit,@12 bit,@13 bit,@14 bit,@15 bit,@16 bit,@17 bit,@18 bit,@19 bit,@20 int,@21 int,@22 int,@23 int,@24 int,@25 int,@26 int,@27 int,@28 int,@29 int,@30 int,@31 int,@32 bit',@0=N'Title21User1',@1='2018-05-10 03:06:06.3286815',@2=1,@3=0,@4=0,@5=0,@6=0,@7=0,@8=0,@9=0,@10=0,@11=0,@12=0,@13=0,@14=0,@15=0,@16=0,@17=0,@18=0,@19=0,@20=0,@21=0,@22=0,@23=0,@24=0,@25=0,@26=0,@27=0,@28=0,@29=0,@30=0,@31=0,@32=0";

	public final String Title21User1_5=
			"exec sp_executesql N'INSERT [dbo].[tblUserFirmMembership]([UserName], [Firm])"
+"VALUES (@0, @1)"
+"',N'@0 nvarchar(20),@1 nvarchar(50)',@0=N'Title21User1',@1=N'Synergen Life Sciences'";

	public final String Title21User1_6=
			"exec sp_executesql N'INSERT [dbo].[tblUserGroupMembership]([UserName], [Firm], [Groups])"
+"VALUES (@0, @1, @2)"
+"',N'@0 nvarchar(20),@1 nvarchar(50),@2 nvarchar(50)',@0=N'Title21User1',@1=N'Synergen Life Sciences',@2=N'Administrators'";

	public final String Title21User1_7=
			"exec sp_executesql N'UPDATE tblOptionSettingsPrivate SET EulaAccepted=@p0 WHERE UserID=@p1',N'@p0 bit,@p1 nvarchar(12)',@p0=1,@p1=N'Title21User1'";
	
	public final String Title21User1_8=
			"exec sp_executesql N'UPDATE tblUserName SET IsSystemAdmin=@p0 WHERE UserName=@p1',N'@p0 bit,@p1 nvarchar(12)',@p0=1,@p1=N'Title21User1'";

	public final String Title21User1_9=
			"exec sp_executesql N'INSERT [dbo].[tblPasswordResponse]([UserName], [ChallengeID], [Response])"
+"VALUES (@0, @1, @2)"
+"',N'@0 nvarchar(20),@1 int,@2 nvarchar(50)',@0=N'Title21User1',@1=1,@2=N'black'";

	public final String Title21User1_10=
			"exec sp_executesql N'INSERT [dbo].[tblPasswordResponse]([UserName], [ChallengeID], [Response])"
+"VALUES (@0, @1, @2)"
+"',N'@0 nvarchar(20),@1 int,@2 nvarchar(50)',@0=N'Title21User1',@1=2,@2=N'mcc'";
	
	
	
	public final String Title21User2_1=
			"exec sp_executesql N'INSERT [dbo].[tblEmployees]([EmployeeID], [Status], [FullName], [Address], [City], [State], [Postal Code], [Country], [Phone], [Email], [Modified], [SupervisorID], [DefaultFirm], [Department], [JobTitle], [HideName], [JobCode], [Location], [EmploymentType], [ForwardItemsTo], [HireDate], [AltEmployeeID])"
+"VALUES (@0, NULL, @1, NULL, NULL, NULL, NULL, NULL, NULL, @2, @3, @4, @5, @6, @7, @8, @9, @10, NULL, NULL, NULL, NULL)"
+"',N'@0 nvarchar(25),@1 nvarchar(50),@2 nvarchar(50),@3 datetime2(7),@4 nvarchar(50),@5 nvarchar(50),@6 nvarchar(50),@7 nvarchar(50),@8 bit,@9 nvarchar(50),@10 nvarchar(50)',@0=N'002',@1=N'Title21User2',@2=N'email@abc.com',@3='2018-05-10 02:57:09.2660772',@4=N'Admin',@5=N'Synergen Life Sciences',@6=N'Document Control',@7=N'Human Resources Clerk',@8=0,@9=N'001099',@10=N'Antioch'";

	public final String Title21User2_2=
			"exec sp_executesql N'INSERT [dbo].[tblTrainingAppliedJobCodes]([EmployeeID], [JobCode], [InJobCodeSince], [ExitJobCodeOn])"
+"VALUES (@0, @1, @2, NULL)"
+"',N'@0 nvarchar(25),@1 nvarchar(50),@2 datetime2(7)',@0=N'002',@1=N'001099',@2='2018-05-10 02:57:09.2817110'";

	public final String Title21User2_3=
			"exec sp_executesql N'INSERT [dbo].[tblUserName]([UserName], [FullName], [Password], [PIN], [PasswordExpiresEvery], [PasswordExpires], [Disabled], [ForcePswChange], [AuthenticationType], [BadLoginPswCount], [Lockout], [PasswordLastChangedOn], [IsSystemAdmin])"
+"VALUES (@0, @1, @2, NULL, NULL, @3, @4, @5, @6, NULL, @7, NULL, NULL)"
+"',N'@0 nvarchar(20),@1 nvarchar(50),@2 nvarchar(128),@3 datetime2(7),@4 bit,@5 bit,@6 tinyint,@7 bit',@0=N'Title21User2',@1=N'Title21User2',@2=N'73682633E3F3A892175E864A593C91F7',@3='2028-05-10 03:06:06.2661009',@4=0,@5=0,@6=1,@7=0";

	public final String Title21User2_4=
			"exec sp_executesql N'INSERT [dbo].[tblOptionSettingsPrivate]([UserID], [Modified], [EULAAccepted], [OnAddNewTaskSetMeToBeNotifiedOnCompletion], [OpenWizardOnStartUp], [TutorialMode], [TutorialModeHome], [TutorialModeTraining], [TutorialModeApproval], [TutorialModeReport], [TutorialModeFavorite], [TutorialModeSearch], [TutorialModeOrganizer], [TutorialModeReview], [DisplayDocHardCopy], [TutorialModePopUp], [TutorialModeChart], [BatchReview], [AutoLoad], [AutoScroll], [PaginationPageSize], [CanSignWithoutReading], [AlterChartPermissions], [OpenDocOnCheckOut], [DocCheckOutIncludeAttachments], [DocCheckOutIncludeDocumentReviewers], [DocCheckOutIncludeTrainingItems], [TaskRequiresESig], [TaskEnableOnAdd], [TaskEmailOnAddNew], [TaskIsDocCollaborationTask], [MyTasksFilterDefaultDay], [MyTasksFilterActionStatusOpen], [MyTasksFilterTaskStatus], [MyDocsVersion], [MyDocsDefaultDay], [MyDocsCabinet], [ViewMode], [MyDocsNcTasksFilterDefaultDay], [MyDocsNcTasksFilterActionStatusOpen], [MyDocsNcTasksFilterTaskStatus], [MyDocsTasksFilterDefaultDay], [MyDocsTasksFilterActionStatusOpen], [MyDocsTasksFilterTaskStatus], [MruListCount], [DefaultLandingPage], [CanCreateCibmtrForm])"
+"VALUES (@0, @1, NULL, NULL, @2, @3, @4, @5, @6, @7, @8, @9, @10, @11, @12, @13, @14, @15, @16, @17, NULL, @18, @19, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, @20, @21, @22, @23, NULL, NULL, @24, @25, @26, @27, @28, @29, @30, NULL, @31, @32)"
+"',N'@0 nvarchar(20),@1 datetime2(7),@2 bit,@3 bit,@4 bit,@5 bit,@6 bit,@7 bit,@8 bit,@9 bit,@10 bit,@11 bit,@12 bit,@13 bit,@14 bit,@15 bit,@16 bit,@17 bit,@18 bit,@19 bit,@20 int,@21 int,@22 int,@23 int,@24 int,@25 int,@26 int,@27 int,@28 int,@29 int,@30 int,@31 int,@32 bit',@0=N'Title21User2',@1='2018-05-10 03:06:06.3286815',@2=1,@3=0,@4=0,@5=0,@6=0,@7=0,@8=0,@9=0,@10=0,@11=0,@12=0,@13=0,@14=0,@15=0,@16=0,@17=0,@18=0,@19=0,@20=0,@21=0,@22=0,@23=0,@24=0,@25=0,@26=0,@27=0,@28=0,@29=0,@30=0,@31=0,@32=0";

	public final String Title21User2_5=
			"exec sp_executesql N'INSERT [dbo].[tblUserFirmMembership]([UserName], [Firm])"
+"VALUES (@0, @1)"
+"',N'@0 nvarchar(20),@1 nvarchar(50)',@0=N'Title21User2',@1=N'Synergen Life Sciences'";

	public final String Title21User2_6=
			"exec sp_executesql N'INSERT [dbo].[tblUserGroupMembership]([UserName], [Firm], [Groups])"
+"VALUES (@0, @1, @2)"
+"',N'@0 nvarchar(20),@1 nvarchar(50),@2 nvarchar(50)',@0=N'Title21User2',@1=N'Synergen Life Sciences',@2=N'Administrators'";

	public final String Title21User2_7=
			"exec sp_executesql N'UPDATE tblOptionSettingsPrivate SET EulaAccepted=@p0 WHERE UserID=@p1',N'@p0 bit,@p1 nvarchar(12)',@p0=1,@p1=N'Title21User2'";
	
	public final String Title21User2_8=
			"exec sp_executesql N'UPDATE tblUserName SET IsSystemAdmin=@p0 WHERE UserName=@p1',N'@p0 bit,@p1 nvarchar(12)',@p0=1,@p1=N'Title21User2'";

	public final String Title21User2_9=
			"exec sp_executesql N'INSERT [dbo].[tblPasswordResponse]([UserName], [ChallengeID], [Response])"
+"VALUES (@0, @1, @2)"
+"',N'@0 nvarchar(20),@1 int,@2 nvarchar(50)',@0=N'Title21User2',@1=1,@2=N'black'";

	public final String Title21User2_10=
			"exec sp_executesql N'INSERT [dbo].[tblPasswordResponse]([UserName], [ChallengeID], [Response])"
+"VALUES (@0, @1, @2)"
+"',N'@0 nvarchar(20),@1 int,@2 nvarchar(50)',@0=N'Title21User2',@1=2,@2=N'mcc'";
	
	
	
	public final String Title21User3_1=
			"exec sp_executesql N'INSERT [dbo].[tblEmployees]([EmployeeID], [Status], [FullName], [Address], [City], [State], [Postal Code], [Country], [Phone], [Email], [Modified], [SupervisorID], [DefaultFirm], [Department], [JobTitle], [HideName], [JobCode], [Location], [EmploymentType], [ForwardItemsTo], [HireDate], [AltEmployeeID])"
+"VALUES (@0, NULL, @1, NULL, NULL, NULL, NULL, NULL, NULL, @2, @3, @4, @5, @6, @7, @8, @9, @10, NULL, NULL, NULL, NULL)"
+"',N'@0 nvarchar(25),@1 nvarchar(50),@2 nvarchar(50),@3 datetime2(7),@4 nvarchar(50),@5 nvarchar(50),@6 nvarchar(50),@7 nvarchar(50),@8 bit,@9 nvarchar(50),@10 nvarchar(50)',@0=N'003',@1=N'Title21User3',@2=N'email@abc.com',@3='2018-05-10 02:57:09.2660772',@4=N'Admin',@5=N'Synergen Life Sciences',@6=N'Document Control',@7=N'Human Resources Clerk',@8=0,@9=N'001099',@10=N'Antioch'";

	public final String Title21User3_2=
			"exec sp_executesql N'INSERT [dbo].[tblTrainingAppliedJobCodes]([EmployeeID], [JobCode], [InJobCodeSince], [ExitJobCodeOn])"
+"VALUES (@0, @1, @2, NULL)"
+"',N'@0 nvarchar(25),@1 nvarchar(50),@2 datetime2(7)',@0=N'003',@1=N'001099',@2='2018-05-10 02:57:09.2817110'";

	public final String Title21User3_3=
			"exec sp_executesql N'INSERT [dbo].[tblUserName]([UserName], [FullName], [Password], [PIN], [PasswordExpiresEvery], [PasswordExpires], [Disabled], [ForcePswChange], [AuthenticationType], [BadLoginPswCount], [Lockout], [PasswordLastChangedOn], [IsSystemAdmin])"
+"VALUES (@0, @1, @2, NULL, NULL, @3, @4, @5, @6, NULL, @7, NULL, NULL)"
+"',N'@0 nvarchar(20),@1 nvarchar(50),@2 nvarchar(128),@3 datetime2(7),@4 bit,@5 bit,@6 tinyint,@7 bit',@0=N'Title21User3',@1=N'Title21User3',@2=N'73682633E3F3A892175E864A593C91F7',@3='2028-05-10 03:06:06.2661009',@4=0,@5=0,@6=1,@7=0";

	public final String Title21User3_4=
			"exec sp_executesql N'INSERT [dbo].[tblOptionSettingsPrivate]([UserID], [Modified], [EULAAccepted], [OnAddNewTaskSetMeToBeNotifiedOnCompletion], [OpenWizardOnStartUp], [TutorialMode], [TutorialModeHome], [TutorialModeTraining], [TutorialModeApproval], [TutorialModeReport], [TutorialModeFavorite], [TutorialModeSearch], [TutorialModeOrganizer], [TutorialModeReview], [DisplayDocHardCopy], [TutorialModePopUp], [TutorialModeChart], [BatchReview], [AutoLoad], [AutoScroll], [PaginationPageSize], [CanSignWithoutReading], [AlterChartPermissions], [OpenDocOnCheckOut], [DocCheckOutIncludeAttachments], [DocCheckOutIncludeDocumentReviewers], [DocCheckOutIncludeTrainingItems], [TaskRequiresESig], [TaskEnableOnAdd], [TaskEmailOnAddNew], [TaskIsDocCollaborationTask], [MyTasksFilterDefaultDay], [MyTasksFilterActionStatusOpen], [MyTasksFilterTaskStatus], [MyDocsVersion], [MyDocsDefaultDay], [MyDocsCabinet], [ViewMode], [MyDocsNcTasksFilterDefaultDay], [MyDocsNcTasksFilterActionStatusOpen], [MyDocsNcTasksFilterTaskStatus], [MyDocsTasksFilterDefaultDay], [MyDocsTasksFilterActionStatusOpen], [MyDocsTasksFilterTaskStatus], [MruListCount], [DefaultLandingPage], [CanCreateCibmtrForm])"
+"VALUES (@0, @1, NULL, NULL, @2, @3, @4, @5, @6, @7, @8, @9, @10, @11, @12, @13, @14, @15, @16, @17, NULL, @18, @19, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, @20, @21, @22, @23, NULL, NULL, @24, @25, @26, @27, @28, @29, @30, NULL, @31, @32)"
+"',N'@0 nvarchar(20),@1 datetime2(7),@2 bit,@3 bit,@4 bit,@5 bit,@6 bit,@7 bit,@8 bit,@9 bit,@10 bit,@11 bit,@12 bit,@13 bit,@14 bit,@15 bit,@16 bit,@17 bit,@18 bit,@19 bit,@20 int,@21 int,@22 int,@23 int,@24 int,@25 int,@26 int,@27 int,@28 int,@29 int,@30 int,@31 int,@32 bit',@0=N'Title21User3',@1='2018-05-10 03:06:06.3286815',@2=1,@3=0,@4=0,@5=0,@6=0,@7=0,@8=0,@9=0,@10=0,@11=0,@12=0,@13=0,@14=0,@15=0,@16=0,@17=0,@18=0,@19=0,@20=0,@21=0,@22=0,@23=0,@24=0,@25=0,@26=0,@27=0,@28=0,@29=0,@30=0,@31=0,@32=0";

	public final String Title21User3_5=
			"exec sp_executesql N'INSERT [dbo].[tblUserFirmMembership]([UserName], [Firm])"
+"VALUES (@0, @1)"
+"',N'@0 nvarchar(20),@1 nvarchar(50)',@0=N'Title21User3',@1=N'Synergen Life Sciences'";

	public final String Title21User3_6=
			"exec sp_executesql N'INSERT [dbo].[tblUserGroupMembership]([UserName], [Firm], [Groups])"
+"VALUES (@0, @1, @2)"
+"',N'@0 nvarchar(20),@1 nvarchar(50),@2 nvarchar(50)',@0=N'Title21User3',@1=N'Synergen Life Sciences',@2=N'Administrators'";

	public final String Title21User3_7=
			"exec sp_executesql N'UPDATE tblOptionSettingsPrivate SET EulaAccepted=@p0 WHERE UserID=@p1',N'@p0 bit,@p1 nvarchar(12)',@p0=1,@p1=N'Title21User3'";
	
	public final String Title21User3_8=
			"exec sp_executesql N'UPDATE tblUserName SET IsSystemAdmin=@p0 WHERE UserName=@p1',N'@p0 bit,@p1 nvarchar(12)',@p0=1,@p1=N'Title21User3'";

	public final String Title21User3_9=
			"exec sp_executesql N'INSERT [dbo].[tblPasswordResponse]([UserName], [ChallengeID], [Response])"
+"VALUES (@0, @1, @2)"
+"',N'@0 nvarchar(20),@1 int,@2 nvarchar(50)',@0=N'Title21User3',@1=1,@2=N'black'";

	public final String Title21User3_10=
			"exec sp_executesql N'INSERT [dbo].[tblPasswordResponse]([UserName], [ChallengeID], [Response])"
+"VALUES (@0, @1, @2)"
+"',N'@0 nvarchar(20),@1 int,@2 nvarchar(50)',@0=N'Title21User3',@1=2,@2=N'mcc'";
	
	
	
	public final String Title21User4_1=
			"exec sp_executesql N'INSERT [dbo].[tblEmployees]([EmployeeID], [Status], [FullName], [Address], [City], [State], [Postal Code], [Country], [Phone], [Email], [Modified], [SupervisorID], [DefaultFirm], [Department], [JobTitle], [HideName], [JobCode], [Location], [EmploymentType], [ForwardItemsTo], [HireDate], [AltEmployeeID])"
+"VALUES (@0, NULL, @1, NULL, NULL, NULL, NULL, NULL, NULL, @2, @3, @4, @5, @6, @7, @8, @9, @10, NULL, NULL, NULL, NULL)"
+"',N'@0 nvarchar(25),@1 nvarchar(50),@2 nvarchar(50),@3 datetime2(7),@4 nvarchar(50),@5 nvarchar(50),@6 nvarchar(50),@7 nvarchar(50),@8 bit,@9 nvarchar(50),@10 nvarchar(50)',@0=N'004',@1=N'Title21User4',@2=N'email@abc.com',@3='2018-05-10 02:57:09.2660772',@4=N'Admin',@5=N'Synergen Life Sciences',@6=N'Document Control',@7=N'Human Resources Clerk',@8=0,@9=N'001099',@10=N'Antioch'";

	public final String Title21User4_2=
			"exec sp_executesql N'INSERT [dbo].[tblTrainingAppliedJobCodes]([EmployeeID], [JobCode], [InJobCodeSince], [ExitJobCodeOn])"
+"VALUES (@0, @1, @2, NULL)"
+"',N'@0 nvarchar(25),@1 nvarchar(50),@2 datetime2(7)',@0=N'004',@1=N'001099',@2='2018-05-10 02:57:09.2817110'";

	public final String Title21User4_3=
			"exec sp_executesql N'INSERT [dbo].[tblUserName]([UserName], [FullName], [Password], [PIN], [PasswordExpiresEvery], [PasswordExpires], [Disabled], [ForcePswChange], [AuthenticationType], [BadLoginPswCount], [Lockout], [PasswordLastChangedOn], [IsSystemAdmin])"
+"VALUES (@0, @1, @2, NULL, NULL, @3, @4, @5, @6, NULL, @7, NULL, NULL)"
+"',N'@0 nvarchar(20),@1 nvarchar(50),@2 nvarchar(128),@3 datetime2(7),@4 bit,@5 bit,@6 tinyint,@7 bit',@0=N'Title21User4',@1=N'Title21User4',@2=N'73682633E3F3A892175E864A593C91F7',@3='2028-05-10 03:06:06.2661009',@4=0,@5=0,@6=1,@7=0";

	public final String Title21User4_4=
			"exec sp_executesql N'INSERT [dbo].[tblOptionSettingsPrivate]([UserID], [Modified], [EULAAccepted], [OnAddNewTaskSetMeToBeNotifiedOnCompletion], [OpenWizardOnStartUp], [TutorialMode], [TutorialModeHome], [TutorialModeTraining], [TutorialModeApproval], [TutorialModeReport], [TutorialModeFavorite], [TutorialModeSearch], [TutorialModeOrganizer], [TutorialModeReview], [DisplayDocHardCopy], [TutorialModePopUp], [TutorialModeChart], [BatchReview], [AutoLoad], [AutoScroll], [PaginationPageSize], [CanSignWithoutReading], [AlterChartPermissions], [OpenDocOnCheckOut], [DocCheckOutIncludeAttachments], [DocCheckOutIncludeDocumentReviewers], [DocCheckOutIncludeTrainingItems], [TaskRequiresESig], [TaskEnableOnAdd], [TaskEmailOnAddNew], [TaskIsDocCollaborationTask], [MyTasksFilterDefaultDay], [MyTasksFilterActionStatusOpen], [MyTasksFilterTaskStatus], [MyDocsVersion], [MyDocsDefaultDay], [MyDocsCabinet], [ViewMode], [MyDocsNcTasksFilterDefaultDay], [MyDocsNcTasksFilterActionStatusOpen], [MyDocsNcTasksFilterTaskStatus], [MyDocsTasksFilterDefaultDay], [MyDocsTasksFilterActionStatusOpen], [MyDocsTasksFilterTaskStatus], [MruListCount], [DefaultLandingPage], [CanCreateCibmtrForm])"
+"VALUES (@0, @1, NULL, NULL, @2, @3, @4, @5, @6, @7, @8, @9, @10, @11, @12, @13, @14, @15, @16, @17, NULL, @18, @19, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, @20, @21, @22, @23, NULL, NULL, @24, @25, @26, @27, @28, @29, @30, NULL, @31, @32)"
+"',N'@0 nvarchar(20),@1 datetime2(7),@2 bit,@3 bit,@4 bit,@5 bit,@6 bit,@7 bit,@8 bit,@9 bit,@10 bit,@11 bit,@12 bit,@13 bit,@14 bit,@15 bit,@16 bit,@17 bit,@18 bit,@19 bit,@20 int,@21 int,@22 int,@23 int,@24 int,@25 int,@26 int,@27 int,@28 int,@29 int,@30 int,@31 int,@32 bit',@0=N'Title21User4',@1='2018-05-10 03:06:06.3286815',@2=1,@3=0,@4=0,@5=0,@6=0,@7=0,@8=0,@9=0,@10=0,@11=0,@12=0,@13=0,@14=0,@15=0,@16=0,@17=0,@18=0,@19=0,@20=0,@21=0,@22=0,@23=0,@24=0,@25=0,@26=0,@27=0,@28=0,@29=0,@30=0,@31=0,@32=0";

	public final String Title21User4_5=
			"exec sp_executesql N'INSERT [dbo].[tblUserFirmMembership]([UserName], [Firm])"
+"VALUES (@0, @1)"
+"',N'@0 nvarchar(20),@1 nvarchar(50)',@0=N'Title21User4',@1=N'Synergen Life Sciences'";

	public final String Title21User4_6=
			"exec sp_executesql N'INSERT [dbo].[tblUserGroupMembership]([UserName], [Firm], [Groups])"
+"VALUES (@0, @1, @2)"
+"',N'@0 nvarchar(20),@1 nvarchar(50),@2 nvarchar(50)',@0=N'Title21User4',@1=N'Synergen Life Sciences',@2=N'Title21Group'";

	public final String Title21User4_7=
			"exec sp_executesql N'UPDATE tblOptionSettingsPrivate SET EulaAccepted=@p0 WHERE UserID=@p1',N'@p0 bit,@p1 nvarchar(12)',@p0=1,@p1=N'Title21User4'";
	

	public final String Title21User4_8=
			"exec sp_executesql N'INSERT [dbo].[tblPasswordResponse]([UserName], [ChallengeID], [Response])"
+"VALUES (@0, @1, @2)"
+"',N'@0 nvarchar(20),@1 int,@2 nvarchar(50)',@0=N'Title21User4',@1=1,@2=N'black'";

	public final String Title21User4_9=
			"exec sp_executesql N'INSERT [dbo].[tblPasswordResponse]([UserName], [ChallengeID], [Response])"
+"VALUES (@0, @1, @2)"
+"',N'@0 nvarchar(20),@1 int,@2 nvarchar(50)',@0=N'Title21User4',@1=2,@2=N'mcc'";
	
	
	public final String Title21User5_1=
			"exec sp_executesql N'INSERT [dbo].[tblEmployees]([EmployeeID], [Status], [FullName], [Address], [City], [State], [Postal Code], [Country], [Phone], [Email], [Modified], [SupervisorID], [DefaultFirm], [Department], [JobTitle], [HideName], [JobCode], [Location], [EmploymentType], [ForwardItemsTo], [HireDate], [AltEmployeeID])"
+"VALUES (@0, NULL, @1, NULL, NULL, NULL, NULL, NULL, NULL, @2, @3, @4, @5, @6, @7, @8, @9, @10, NULL, NULL, NULL, NULL)"
+"',N'@0 nvarchar(25),@1 nvarchar(50),@2 nvarchar(50),@3 datetime2(7),@4 nvarchar(50),@5 nvarchar(50),@6 nvarchar(50),@7 nvarchar(50),@8 bit,@9 nvarchar(50),@10 nvarchar(50)',@0=N'005',@1=N'Title21User5',@2=N'email@abc.com',@3='2018-05-10 02:57:09.2660772',@4=N'Admin',@5=N'Synergen Life Sciences',@6=N'Document Control',@7=N'Human Resources Clerk',@8=0,@9=N'001099',@10=N'Antioch'";

	public final String Title21User5_2=
			"exec sp_executesql N'INSERT [dbo].[tblTrainingAppliedJobCodes]([EmployeeID], [JobCode], [InJobCodeSince], [ExitJobCodeOn])"
+"VALUES (@0, @1, @2, NULL)"
+"',N'@0 nvarchar(25),@1 nvarchar(50),@2 datetime2(7)',@0=N'005',@1=N'001099',@2='2018-05-10 02:57:09.2817110'";

	public final String Title21User5_3=
			"exec sp_executesql N'INSERT [dbo].[tblUserName]([UserName], [FullName], [Password], [PIN], [PasswordExpiresEvery], [PasswordExpires], [Disabled], [ForcePswChange], [AuthenticationType], [BadLoginPswCount], [Lockout], [PasswordLastChangedOn], [IsSystemAdmin])"
+"VALUES (@0, @1, @2, NULL, NULL, @3, @4, @5, @6, NULL, @7, NULL, NULL)"
+"',N'@0 nvarchar(20),@1 nvarchar(50),@2 nvarchar(128),@3 datetime2(7),@4 bit,@5 bit,@6 tinyint,@7 bit',@0=N'Title21User5',@1=N'Title21User5',@2=N'73682633E3F3A892175E864A593C91F7',@3='2028-05-10 03:06:06.2661009',@4=0,@5=0,@6=1,@7=0";

	public final String Title21User5_4=
			"exec sp_executesql N'INSERT [dbo].[tblOptionSettingsPrivate]([UserID], [Modified], [EULAAccepted], [OnAddNewTaskSetMeToBeNotifiedOnCompletion], [OpenWizardOnStartUp], [TutorialMode], [TutorialModeHome], [TutorialModeTraining], [TutorialModeApproval], [TutorialModeReport], [TutorialModeFavorite], [TutorialModeSearch], [TutorialModeOrganizer], [TutorialModeReview], [DisplayDocHardCopy], [TutorialModePopUp], [TutorialModeChart], [BatchReview], [AutoLoad], [AutoScroll], [PaginationPageSize], [CanSignWithoutReading], [AlterChartPermissions], [OpenDocOnCheckOut], [DocCheckOutIncludeAttachments], [DocCheckOutIncludeDocumentReviewers], [DocCheckOutIncludeTrainingItems], [TaskRequiresESig], [TaskEnableOnAdd], [TaskEmailOnAddNew], [TaskIsDocCollaborationTask], [MyTasksFilterDefaultDay], [MyTasksFilterActionStatusOpen], [MyTasksFilterTaskStatus], [MyDocsVersion], [MyDocsDefaultDay], [MyDocsCabinet], [ViewMode], [MyDocsNcTasksFilterDefaultDay], [MyDocsNcTasksFilterActionStatusOpen], [MyDocsNcTasksFilterTaskStatus], [MyDocsTasksFilterDefaultDay], [MyDocsTasksFilterActionStatusOpen], [MyDocsTasksFilterTaskStatus], [MruListCount], [DefaultLandingPage], [CanCreateCibmtrForm])"
+"VALUES (@0, @1, NULL, NULL, @2, @3, @4, @5, @6, @7, @8, @9, @10, @11, @12, @13, @14, @15, @16, @17, NULL, @18, @19, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, @20, @21, @22, @23, NULL, NULL, @24, @25, @26, @27, @28, @29, @30, NULL, @31, @32)"
+"',N'@0 nvarchar(20),@1 datetime2(7),@2 bit,@3 bit,@4 bit,@5 bit,@6 bit,@7 bit,@8 bit,@9 bit,@10 bit,@11 bit,@12 bit,@13 bit,@14 bit,@15 bit,@16 bit,@17 bit,@18 bit,@19 bit,@20 int,@21 int,@22 int,@23 int,@24 int,@25 int,@26 int,@27 int,@28 int,@29 int,@30 int,@31 int,@32 bit',@0=N'Title21User5',@1='2018-05-10 03:06:06.3286815',@2=1,@3=0,@4=0,@5=0,@6=0,@7=0,@8=0,@9=0,@10=0,@11=0,@12=0,@13=0,@14=0,@15=0,@16=0,@17=0,@18=0,@19=0,@20=0,@21=0,@22=0,@23=0,@24=0,@25=0,@26=0,@27=0,@28=0,@29=0,@30=0,@31=0,@32=0";

	public final String Title21User5_5=
			"exec sp_executesql N'INSERT [dbo].[tblUserFirmMembership]([UserName], [Firm])"
+"VALUES (@0, @1)"
+"',N'@0 nvarchar(20),@1 nvarchar(50)',@0=N'Title21User5',@1=N'Synergen Life Sciences'";

	public final String Title21User5_6=
			"exec sp_executesql N'INSERT [dbo].[tblUserGroupMembership]([UserName], [Firm], [Groups])"
+"VALUES (@0, @1, @2)"
+"',N'@0 nvarchar(20),@1 nvarchar(50),@2 nvarchar(50)',@0=N'Title21User5',@1=N'Synergen Life Sciences',@2=N'Title21Group'";

	public final String Title21User5_7=
			"exec sp_executesql N'UPDATE tblOptionSettingsPrivate SET EulaAccepted=@p0 WHERE UserID=@p1',N'@p0 bit,@p1 nvarchar(12)',@p0=1,@p1=N'Title21User5'";
	

	public final String Title21User5_8=
			"exec sp_executesql N'INSERT [dbo].[tblPasswordResponse]([UserName], [ChallengeID], [Response])"
+"VALUES (@0, @1, @2)"
+"',N'@0 nvarchar(20),@1 int,@2 nvarchar(50)',@0=N'Title21User5',@1=1,@2=N'black'";

	public final String Title21User5_9=
			"exec sp_executesql N'INSERT [dbo].[tblPasswordResponse]([UserName], [ChallengeID], [Response])"
+"VALUES (@0, @1, @2)"
+"',N'@0 nvarchar(20),@1 int,@2 nvarchar(50)',@0=N'Title21User5',@1=2,@2=N'mcc'";
	
}
