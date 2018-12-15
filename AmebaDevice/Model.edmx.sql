
-- --------------------------------------------------
-- Entity Designer DDL Script for SQL Server 2005, 2008, 2012 and Azure
-- --------------------------------------------------
-- Date Created: 12/14/2018 16:29:00
-- Generated from EDMX file: D:\dotnet\AmebaDevice\AmebaDevice\AmebaDevice\Model.edmx
-- --------------------------------------------------

SET QUOTED_IDENTIFIER OFF;
GO
USE [dbamebadevice];
GO
IF SCHEMA_ID(N'dbo') IS NULL EXECUTE(N'CREATE SCHEMA [dbo]');
GO

-- --------------------------------------------------
-- Dropping existing FOREIGN KEY constraints
-- --------------------------------------------------

IF OBJECT_ID(N'[dbo].[FK_CustomerBuilding]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Building] DROP CONSTRAINT [FK_CustomerBuilding];
GO

-- --------------------------------------------------
-- Dropping existing tables
-- --------------------------------------------------

IF OBJECT_ID(N'[dbo].[Customer]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Customer];
GO
IF OBJECT_ID(N'[dbo].[Building]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Building];
GO

-- --------------------------------------------------
-- Creating all tables
-- --------------------------------------------------

-- Creating table 'Customer'
CREATE TABLE [dbo].[Customer] (
    [CustomerID] int IDENTITY(1,1) NOT NULL,
    [Nome] nvarchar(max)  NOT NULL,
    [Cognome] nvarchar(max)  NOT NULL,
    [Username] nvarchar(max)  NOT NULL,
    [Password] nvarchar(max)  NOT NULL,
    [Email] nvarchar(max)  NOT NULL,
    [User_role] nvarchar(max)  NOT NULL
);
GO

-- Creating table 'Building'
CREATE TABLE [dbo].[Building] (
    [BuildingID] int IDENTITY(1,1) NOT NULL,
    [Indirizzo] nvarchar(max)  NOT NULL,
    [Cap] nvarchar(max)  NOT NULL,
    [Citta] nvarchar(max)  NOT NULL,
    [Interno] nvarchar(max)  NOT NULL,
    [Customer_CustomerID] int  NOT NULL
);
GO

-- --------------------------------------------------
-- Creating all PRIMARY KEY constraints
-- --------------------------------------------------

-- Creating primary key on [CustomerID] in table 'Customer'
ALTER TABLE [dbo].[Customer]
ADD CONSTRAINT [PK_Customer]
    PRIMARY KEY CLUSTERED ([CustomerID] ASC);
GO

-- Creating primary key on [BuildingID] in table 'Building'
ALTER TABLE [dbo].[Building]
ADD CONSTRAINT [PK_Building]
    PRIMARY KEY CLUSTERED ([BuildingID] ASC);
GO

-- --------------------------------------------------
-- Creating all FOREIGN KEY constraints
-- --------------------------------------------------

-- Creating foreign key on [Customer_CustomerID] in table 'Building'
ALTER TABLE [dbo].[Building]
ADD CONSTRAINT [FK_CustomerBuilding]
    FOREIGN KEY ([Customer_CustomerID])
    REFERENCES [dbo].[Customer]
        ([CustomerID])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_CustomerBuilding'
CREATE INDEX [IX_FK_CustomerBuilding]
ON [dbo].[Building]
    ([Customer_CustomerID]);
GO

-- --------------------------------------------------
-- Script has ended
-- --------------------------------------------------