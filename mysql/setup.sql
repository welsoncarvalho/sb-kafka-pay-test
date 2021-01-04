-- Error Table
CREATE TABLE error (
    id varchar(100) NOT NULL, 
    message varchar(500), 
    created_at date, 
    type varchar(500), 
    type_id varchar(100), 
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 DEFAULT COLLATE=latin1_swedish_ci;

-- Account Table
CREATE TABLE account (
    id varchar(100) NOT NULL, 
    name varchar(100), 
    email varchar(100), 
    password varchar(100), 
    created_at date, 
    status varchar(50), 
    error_id varchar(50), 
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 DEFAULT COLLATE=latin1_swedish_ci;

-- Address Table
CREATE TABLE address (
    id varchar(100) NOT NULL, 
    address varchar(100), 
    city varchar(100), 
    state varchar(2), 
    zip_code varchar(20), 
    main int(1), 
    created_at date, 
    account_id varchar(100), 
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 DEFAULT COLLATE=latin1_swedish_ci;

-- Payment Table
CREATE TABLE payment (
    id varchar(100) NOT NULL, 
    card varchar(100), 
    cvv varchar(100), 
    brand varchar(100), 
    valid_date varchar(20), 
    created_at date, 
    account_id varchar(100), 
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 DEFAULT COLLATE=latin1_swedish_ci;
