#user
create table user
(
    userID    varchar(36) primary key,
    roleID    varchar(36)                           not null,
    username  varchar(36) null,
    password  varchar(255)                          not null,
    email     varchar(36)                           not null unique,
    phone     varchar(10) null,
    pathImage varchar(255),
    status    enum ('ACTIVE', 'IN_ACTIVE', 'LOCK') default 'ACTIVE',
    createdAt timestamp   default CURRENT_TIMESTAMP not null,
    updatedAt timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    createdBy varchar(36) default 'system'          not null,
    updatedBy varchar(36) default 'system'          not null,
    foreign key (roleID) references role (roleID),
);

#role
create table role
(
    roleID    varchar(36) primary key,
    roleName  varchar(36) null,
    createdAt timestamp   default CURRENT_TIMESTAMP not null,
    updatedAt timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    createdBy varchar(36) default 'system'          not null,
    updatedBy varchar(36) default 'system'          not null
);

create table verify_code
(
    verifyCodeID varchar(36)                           not null primary key,
    code         varchar(36)                           not null,
    email        varchar(50)                           not null unique,
    status       enum ('ACTIVE', 'IN_ACTIVE') default 'ACTIVE'          not null,
    createdAt    timestamp   default CURRENT_TIMESTAMP not null,
    updatedAt    timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    createdBy    varchar(36) default 'system'          not null,
    updatedBy    varchar(36) default 'system'          not null
);

- neu quantity > 0 thi trang thai san pham IN_STOCK (con hang)
- neu quantity = 0 thi trang thai san pham OUT_OF_STOCK (het hang)
- neu status = IN_TRANSIT (dang van chuyen)
- neu status = PENDING_PAYMENT (cho thanh toan)
- neu status = PAID (da thanh toan)
- neu status = CANCELLED (don hang da huy)
- neu status = DELIVERED (da giao hang)
#product
create table product
(
    productID   varchar(36) primary key,
    userID      varchar(36)                           not null,
    promotionID varchar(36)                           not null,
    warehouseID varchar(36)                           not null,
    pathImage   varchar(255)                          not null,
    description TEXT,
    status      enum ('ACTIVE', 'IN_ACTIVE') default 'ACTIVE',
    createdAt   timestamp   default CURRENT_TIMESTAMP not null,
    updatedAt   timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    createdBy   varchar(36) default 'system'          not null,
    updatedBy   varchar(36) default 'system'          not null,
    foreign key (userID) references user (userID),
    foreign key (warehouseID) references warehouse (warehouseID),
    foreign key (promotionID) references promotion (promotionID),
);

#promotion
create table promotion
(
    promotionID     varchar(36) primary key,
    description     TEXT,
    discountPercent int                                   not null,
    status          enum ('ACTIVE', 'IN_ACTIVE') default 'ACTIVE',
    createdAt TIMESTAMP   DEFAULT CURRENT_TIMESTAMP not null,
    updatedAt       TIMESTAMP   DEFAULT CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    createdBy       varchar(36) default 'system'          not null,
    updatedBy       varchar(36) default 'system'          not null,
    CHECK (discountPercent >= 0 AND discountPercent <= 100)
);

#order
create table order
(
    orderID        varchar(36) primary key,
    userID         varchar(36) not null,
    productID      varchar(36) not null,
    paymentStatus  enum ('PENDING_PAYMENT', 'PAID') default 'PENDING_PAYMENT',
    deliveryStatus enum ('IN_TRANSIT', 'CANCELLED', 'DELIVERED') default 'IN_TRANSIT',
    FOREIGN KEY (userID) REFERENCES user (userID),
    FOREIGN KEY (productID) REFERENCES product (productID)
);

#warehouse
create table warehouse
(
    warehouseID varchar(36) primary key,
    quantity    int                                   not null default 0,
    maxStorage  int                                   not null default 0,
    location    varchar(255)                          not null,
    createdAt   TIMESTAMP   DEFAULT CURRENT_TIMESTAMP not null,
    updatedAt   TIMESTAMP   DEFAULT CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    createdBy   varchar(36) default 'system'          not null,
    updatedBy   varchar(36) default 'system'          not null
);

#stock_out
create table stock_out
(
    stockOutID  varchar(36) primary key,
    productID   varchar(36)                           not null,
    warehouseID varchar(36)                           not null,
    quantity    int                                   not null,
    createdAt   timestamp   default CURRENT_TIMESTAMP not null,
    updatedAt   timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    createdBy   varchar(36) default 'system'          not null,
    updatedBy   varchar(36) default 'system'          not null,
    foreign key (userID) references user (userID)
);

#stock_in
create table stock_in
(
    stockInID   varchar(36) primary key,
    productID   varchar(36)                           not null,
    warehouseID varchar(36)                           not null,
    quantity    int                                   not null,
    createdAt   timestamp   default CURRENT_TIMESTAMP not null,
    updatedAt   timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    createdBy   varchar(36) default 'system'          not null,
    updatedBy   varchar(36) default 'system'          not null,
    foreign key (userID) references user (userID)
);