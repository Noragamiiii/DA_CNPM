USE [QuanLiTiemChung]
GO
/****** Object:  Table [dbo].[Animal]    Script Date: 6/6/2020 9:27:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Animal](
	[idVatNuoi] [nvarchar](100) NOT NULL,
	[Vatnuoi_name] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[idVatNuoi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DangkiTiem]    Script Date: 6/6/2020 9:27:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DangkiTiem](
	[idHoDan] [int] IDENTITY(1,1) NOT NULL,
	[idVaccine] [nvarchar](100) NOT NULL,
	[idVatNuoi] [nvarchar](100) NOT NULL,
	[Number] [int] NULL,
	[Date_register] [datetime] NULL,
 CONSTRAINT [PK_hodan_vaccine] PRIMARY KEY CLUSTERED 
(
	[idHoDan] ASC,
	[idVaccine] ASC,
	[idVatNuoi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[News]    Script Date: 6/6/2020 9:27:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[News](
	[idNews] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](500) NULL,
	[LinktoWeb] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[idNews] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Person]    Script Date: 6/6/2020 9:27:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Person](
	[idHoDan] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](100) NULL,
	[iPassword] [nvarchar](100) NULL,
	[Fullname] [nvarchar](100) NULL,
	[Gender] [nvarchar](100) NULL,
	[PhoneNumber] [nvarchar](100) NULL,
	[iAddress] [nvarchar](100) NULL,
	[Dob] [date] NULL,
	[irole] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[idHoDan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vaccine_r]    Script Date: 6/6/2020 9:27:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vaccine_r](
	[idVaccine] [nvarchar](100) NOT NULL,
	[Vaccine_name] [nvarchar](100) NULL,
	[Number] [int] NULL,
	[idVatNuoi] [nvarchar](100) NULL,
 CONSTRAINT [PK_Vaccine_r] PRIMARY KEY CLUSTERED 
(
	[idVaccine] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Animal] ([idVatNuoi], [Vatnuoi_name]) VALUES (N'Anic_6', N'Ngan')
INSERT [dbo].[Animal] ([idVatNuoi], [Vatnuoi_name]) VALUES (N'Anic_7', N'Vịt')
INSERT [dbo].[Animal] ([idVatNuoi], [Vatnuoi_name]) VALUES (N'Anic_8', N'Ngỗng')
INSERT [dbo].[Animal] ([idVatNuoi], [Vatnuoi_name]) VALUES (N'Anic_9', N'Gà')
INSERT [dbo].[Animal] ([idVatNuoi], [Vatnuoi_name]) VALUES (N'Anis_1', N'Bò')
INSERT [dbo].[Animal] ([idVatNuoi], [Vatnuoi_name]) VALUES (N'Anis_2', N'Trâu')
INSERT [dbo].[Animal] ([idVatNuoi], [Vatnuoi_name]) VALUES (N'Anis_3', N'Dê')
INSERT [dbo].[Animal] ([idVatNuoi], [Vatnuoi_name]) VALUES (N'Anis_4', N'Cừu')
INSERT [dbo].[Animal] ([idVatNuoi], [Vatnuoi_name]) VALUES (N'Anis_5', N'Heo')
SET IDENTITY_INSERT [dbo].[Person] ON 

INSERT [dbo].[Person] ([idHoDan], [Username], [iPassword], [Fullname], [Gender], [PhoneNumber], [iAddress], [Dob], [irole]) VALUES (2, N'ngochuyen', N'youkill', N'Nguyen Ngoc Huyen', NULL, N'0338698917', N'Quang Tri', CAST(N'2000-06-10' AS Date), NULL)
INSERT [dbo].[Person] ([idHoDan], [Username], [iPassword], [Fullname], [Gender], [PhoneNumber], [iAddress], [Dob], [irole]) VALUES (3, N'jvfk', N'youkill', N'Ngoc Huyen Nguyen', N'Nữ', N'00000122121', N'Quảng Trị', CAST(N'2000-02-02' AS Date), NULL)
INSERT [dbo].[Person] ([idHoDan], [Username], [iPassword], [Fullname], [Gender], [PhoneNumber], [iAddress], [Dob], [irole]) VALUES (5, N'Ngochuyennguyen', N'ngochuyennguyen', N'Nguyen Ngoc Huyen', N'Nữ', N'123123123', N'Quang Tri', CAST(N'2000-09-23' AS Date), NULL)
INSERT [dbo].[Person] ([idHoDan], [Username], [iPassword], [Fullname], [Gender], [PhoneNumber], [iAddress], [Dob], [irole]) VALUES (6, N'Ngochuyen2309', N'ngochuyen2309', N'Nguyen Ngoc Huyen', N'Nam', N'12341234', N'Da Nang', CAST(N'2000-02-02' AS Date), NULL)
INSERT [dbo].[Person] ([idHoDan], [Username], [iPassword], [Fullname], [Gender], [PhoneNumber], [iAddress], [Dob], [irole]) VALUES (7, N'ErinAbbey', N'_jvf_k', N'Nguyễn Ngọc Huyền', N'Nữ', N'0338698917', N'TX Quảng Trị', CAST(N'2000-06-10' AS Date), N'Admin')
INSERT [dbo].[Person] ([idHoDan], [Username], [iPassword], [Fullname], [Gender], [PhoneNumber], [iAddress], [Dob], [irole]) VALUES (8, N'30thnags9', N'Trangmoon309', N'Huỳnh Nguyễn Phương Trang', N'Nữ', N'0338698918', N'Duy Xuyên, Quảng Nam', CAST(N'2000-09-30' AS Date), N'Admin')
INSERT [dbo].[Person] ([idHoDan], [Username], [iPassword], [Fullname], [Gender], [PhoneNumber], [iAddress], [Dob], [irole]) VALUES (9, N'Conthobeo', N'queenqueen', N'Hoàng Ngọc Khánh Quỳnh', N'Nữ', N'0338698919', N'Cẩm Lệ, Đà Nẵng', CAST(N'2000-03-15' AS Date), N'Admin')
INSERT [dbo].[Person] ([idHoDan], [Username], [iPassword], [Fullname], [Gender], [PhoneNumber], [iAddress], [Dob], [irole]) VALUES (10, N'ngochuyen', N'ngochuyen', N'ngoc huyen', N'Nữ', N'12341234', N'ngoc huyen', CAST(N'2000-02-02' AS Date), N'Ho dan')
INSERT [dbo].[Person] ([idHoDan], [Username], [iPassword], [Fullname], [Gender], [PhoneNumber], [iAddress], [Dob], [irole]) VALUES (11, N'cccc', N'cccc', N'ccc', N'Nữ', N'12341234', N'cccc', CAST(N'2000-02-02' AS Date), NULL)
SET IDENTITY_INSERT [dbo].[Person] OFF
INSERT [dbo].[Vaccine_r] ([idVaccine], [Vaccine_name], [Number], [idVatNuoi]) VALUES (N'Vacc_1', N'Baytril 0.5% Oral Sol', 1000, N'Anis_5')
INSERT [dbo].[Vaccine_r] ([idVaccine], [Vaccine_name], [Number], [idVatNuoi]) VALUES (N'Vacc_2', N'Vô tụ huyết trùng', 1000, N'Anis_1')
INSERT [dbo].[Vaccine_r] ([idVaccine], [Vaccine_name], [Number], [idVatNuoi]) VALUES (N'Vacc_3', N'Latibon', 1000, N'Anic_9')
INSERT [dbo].[Vaccine_r] ([idVaccine], [Vaccine_name], [Number], [idVatNuoi]) VALUES (N'Vacc_4', N'Vô tụ huyết trùng', 1000, N'Anis_2')
INSERT [dbo].[Vaccine_r] ([idVaccine], [Vaccine_name], [Number], [idVatNuoi]) VALUES (N'Vacc_5', N'Lactovet', 1000, N'Anic_6')
INSERT [dbo].[Vaccine_r] ([idVaccine], [Vaccine_name], [Number], [idVatNuoi]) VALUES (N'Vacc_6', N'Lactovet', 1000, N'Anic_7')
INSERT [dbo].[Vaccine_r] ([idVaccine], [Vaccine_name], [Number], [idVatNuoi]) VALUES (N'Vacc_7', N'Lactovet', 1000, N'Anic_8')
INSERT [dbo].[Vaccine_r] ([idVaccine], [Vaccine_name], [Number], [idVatNuoi]) VALUES (N'Vacc_8', N'Đậu dê', 1000, N'Anis_3')
INSERT [dbo].[Vaccine_r] ([idVaccine], [Vaccine_name], [Number], [idVatNuoi]) VALUES (N'Vacc_9', N'Rabisin', 1000, N'Anis_4')
ALTER TABLE [dbo].[Vaccine_r]  WITH CHECK ADD  CONSTRAINT [FK_Vaccine_r_Animal] FOREIGN KEY([idVatNuoi])
REFERENCES [dbo].[Animal] ([idVatNuoi])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Vaccine_r] CHECK CONSTRAINT [FK_Vaccine_r_Animal]
GO
