--<ScriptOptions statementTerminator="GO"/>

ALTER TABLE "dbo"."HD" DROP CONSTRAINT "PK__HD__4C467244239E4DCF"
GO

DROP TABLE "dbo"."HD"
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE "dbo"."HD" (
	"idHoDan" INT NOT NULL,
	"idVatNuoi" INT,
	"username" null,
	"ipassword" null,
	"hoten" null,
	"gioitinh" null,
	"sodienthoai" null,
	"diachi" null,
	"sogiayphep" null,
	"dob" null,
	CONSTRAINT "PK__HD__4C467244239E4DCF" PRIMARY KEY ("idHoDan") WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)

)
GO

SET ANSI_PADDING OFF
GO

