CREATE TABLE 'slack','report_histories' (
                                            'id' INT NOT NULL,
                                            'market' VARCHAR(45) NOT NULL,
                                            'price' VARCHAR(45) NOT NULL,
                                            'reported_at' DATE NOT NULL,
                                            PRIMARY KEY (id)
);