
-- --------------------------------------------------
-- Entity Designer DDL Script for SQL Server 2005, 2008, 2012 and Azure
-- --------------------------------------------------
-- Date Created: 12/18/2018 09:50:13
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
IF OBJECT_ID(N'[dbo].[FK_BuildingFloor]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Floor] DROP CONSTRAINT [FK_BuildingFloor];
GO
IF OBJECT_ID(N'[dbo].[FK_FloorRoom]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Room] DROP CONSTRAINT [FK_FloorRoom];
GO
IF OBJECT_ID(N'[dbo].[FK_CustomerThing]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[ThingSet] DROP CONSTRAINT [FK_CustomerThing];
GO
IF OBJECT_ID(N'[dbo].[FK_BuildingThing]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[ThingSet] DROP CONSTRAINT [FK_BuildingThing];
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
IF OBJECT_ID(N'[dbo].[Floor]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Floor];
GO
IF OBJECT_ID(N'[dbo].[Room]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Room];
GO
IF OBJECT_ID(N'[dbo].[ThingSet]', 'U') IS NOT NULL
    DROP TABLE [dbo].[ThingSet];
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
    [Customer_CustomerID] int  NULL
);
GO

-- Creating table 'Floor'
CREATE TABLE [dbo].[Floor] (
    [FloorID] int IDENTITY(1,1) NOT NULL,
    [Nome] nvarchar(max)  NOT NULL,
    [Descrizione] nvarchar(max)  NOT NULL,
    [Building_BuildingID] int  NOT NULL
);
GO

-- Creating table 'Room'
CREATE TABLE [dbo].[Room] (
    [RoomId] int IDENTITY(1,1) NOT NULL,
    [Nome] nvarchar(max)  NOT NULL,
    [Descrizione] nvarchar(max)  NOT NULL,
    [Floor_FloorID] int  NOT NULL
);
GO

-- Creating table 'Thing'
CREATE TABLE [dbo].[Thing] (
    [ThingID] int IDENTITY(1,1) NOT NULL,
    [Num_Uscite] nvarchar(max)  NOT NULL,
    [Prezzo] float  NOT NULL,
    [Customer_CustomerID] int  NULL,
    [Building_BuildingID] int  NOT NULL
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

-- Creating primary key on [FloorID] in table 'Floor'
ALTER TABLE [dbo].[Floor]
ADD CONSTRAINT [PK_Floor]
    PRIMARY KEY CLUSTERED ([FloorID] ASC);
GO

-- Creating primary key on [RoomId] in table 'Room'
ALTER TABLE [dbo].[Room]
ADD CONSTRAINT [PK_Room]
    PRIMARY KEY CLUSTERED ([RoomId] ASC);
GO

-- Creating primary key on [ThingID] in table 'Thing'
ALTER TABLE [dbo].[Thing]
ADD CONSTRAINT [PK_Thing]
    PRIMARY KEY CLUSTERED ([ThingID] ASC);
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
    ON DELETE SET NULL ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_CustomerBuilding'
CREATE INDEX [IX_FK_CustomerBuilding]
ON [dbo].[Building]
    ([Customer_CustomerID]);
GO

-- Creating foreign key on [Building_BuildingID] in table 'Floor'
ALTER TABLE [dbo].[Floor]
ADD CONSTRAINT [FK_BuildingFloor]
    FOREIGN KEY ([Building_BuildingID])
    REFERENCES [dbo].[Building]
        ([BuildingID])
    ON DELETE CASCADE ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_BuildingFloor'
CREATE INDEX [IX_FK_BuildingFloor]
ON [dbo].[Floor]
    ([Building_BuildingID]);
GO

-- Creating foreign key on [Floor_FloorID] in table 'Room'
ALTER TABLE [dbo].[Room]
ADD CONSTRAINT [FK_FloorRoom]
    FOREIGN KEY ([Floor_FloorID])
    REFERENCES [dbo].[Floor]
        ([FloorID])
    ON DELETE CASCADE ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_FloorRoom'
CREATE INDEX [IX_FK_FloorRoom]
ON [dbo].[Room]
    ([Floor_FloorID]);
GO

-- Creating foreign key on [Customer_CustomerID] in table 'Thing'
ALTER TABLE [dbo].[Thing]
ADD CONSTRAINT [FK_CustomerThing]
    FOREIGN KEY ([Customer_CustomerID])
    REFERENCES [dbo].[Customer]
        ([CustomerID])
    ON DELETE SET NULL ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_CustomerThing'
CREATE INDEX [IX_FK_CustomerThing]
ON [dbo].[Thing]
    ([Customer_CustomerID]);
GO

-- Creating foreign key on [Building_BuildingID] in table 'Thing'
ALTER TABLE [dbo].[Thing]
ADD CONSTRAINT [FK_BuildingThing]
    FOREIGN KEY ([Building_BuildingID])
    REFERENCES [dbo].[Building]
        ([BuildingID])
    ON DELETE CASCADE ON UPDATE CASCADE;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_BuildingThing'
CREATE INDEX [IX_FK_BuildingThing]
ON [dbo].[Thing]
    ([Building_BuildingID]);
GO

-- --------------------------------------------------
-- Script has ended
-- --------------------------------------------------