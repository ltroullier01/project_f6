USE team6f;
INSERT INTO flights (
        ref,
        departure_city,
        destination_city,
        layover,
        departure_time,
        arrival_time,
        price,
        duration,
        carbon_footprint
    )
VALUES (
        'AA123',
        'New York',
        'Tokyo',
        2,
        '2025-02-15',
        '2025-02-15',
        299.99,
        8,
        0.5
    ),
    (
        'BB456',
        'Los Angeles',
        'London',
        150,
        '2025-02-16',
        '2025-02-16',
        750.00,
        120,
        0.1
    ),
    (
        'CC789',
        'Chicago',
        'Paris',
        100,
        '2025-02-17',
        '2025-02-17',
        600.00,
        90,
        0.2
    ),
    (
        'DD012',
        'Houston',
        'Sydney',
        50,
        '2025-02-18',
        '2025-02-19',
        1200.00,
        40,
        0.05
    ),
    (
        'EE345',
        'Miami',
        'Rio de Janeiro',
        80,
        '2025-02-19',
        '2025-02-20',
        400.00,
        65,
        0.15
    ),
    (
        'FF678',
        'San Francisco',
        'Hong Kong',
        120,
        '2025-02-20',
        '2025-02-21',
        900.00,
        100,
        0.1
    ),
    (
        'GG901',
        'Atlanta',
        'Berlin',
        90,
        '2025-02-21',
        '2025-02-22',
        550.00,
        75,
        0.25
    ),
    (
        'HH234',
        'Dallas',
        'Rome',
        70,
        '2025-02-22',
        '2025-02-23',
        650.00,
        55,
        0.2
    ),
    (
        'II567',
        'Seattle',
        'Amsterdam',
        110,
        '2025-02-23',
        '2025-02-23',
        700.00,
        95,
        0.1
    ),
    (
        'JJ890',
        'Boston',
        'Madrid',
        60,
        '2025-02-24',
        '2025-02-24',
        500.00,
        48,
        0.3
    ),
    (
        'KK123',
        'New York',
        'Paris',
        30,
        '2025-02-25',
        '2025-02-25',
        550.00,
        25,
        0.1
    ),
    (
        'LL456',
        'Los Angeles',
        'Tokyo',
        140,
        '2025-02-26',
        '2025-02-27',
        800.00,
        110,
        0.15
    ),
    (
        'MM789',
        'Chicago',
        'London',
        90,
        '2025-02-27',
        '2025-02-28',
        650.00,
        80,
        0.2
    ),
    (
        'NN012',
        'Houston',
        'Sydney',
        40,
        '2025-02-28',
        '2025-03-01',
        1300.00,
        35,
        0.05
    ),
    (
        'OO345',
        'Miami',
        'Rio de Janeiro',
        70,
        '2025-03-01',
        '2025-03-02',
        450.00,
        60,
        0.15
    ),
    (
        'PP678',
        'San Francisco',
        'Hong Kong',
        110,
        '2025-03-02',
        '2025-03-03',
        950.00,
        95,
        0.1
    ),
    (
        'QQ901',
        'Atlanta',
        'Berlin',
        80,
        '2025-03-03',
        '2025-03-04',
        600.00,
        70,
        0.25
    ),
    (
        'RR234',
        'Dallas',
        'Rome',
        60,
        '2025-03-04',
        '2025-03-05',
        700.00,
        50,
        0.2
    ),
    (
        'SS567',
        'Seattle',
        'Amsterdam',
        100,
        '2025-03-05',
        '2025-03-05',
        750.00,
        90,
        0.1
    ),
    (
        'TT890',
        'Boston',
        'Madrid',
        50,
        '2025-03-06',
        '2025-03-06',
        550.00,
        43,
        0.3
    ),
    (
        'UU123',
        'New York',
        'London',
        120,
        '2025-03-07',
        '2025-03-07',
        600.00,
        105,
        0.1
    ),
    (
        'VV456',
        'Los Angeles',
        'Sydney',
        60,
        '2025-03-08',
        '2025-03-09',
        1250.00,
        55,
        0.05
    ),
    (
        'WW789',
        'Chicago',
        'Paris',
        85,
        '2025-03-09',
        '2025-03-10',
        700.00,
        75,
        0.2
    ),
    (
        'XX012',
        'Houston',
        'Tokyo',
        100,
        '2025-03-10',
        '2025-03-11',
        900.00,
        90,
        0.1
    ),
    (
        'YY345',
        'Miami',
        'Berlin',
        75,
        '2025-03-11',
        '2025-03-12',
        500.00,
        65,
        0.25
    ),
    (
        'ZZ678',
        'San Francisco',
        'Rome',
        65,
        '2025-03-12',
        '2025-03-13',
        750.00,
        60,
        0.2
    ),
    (
        'AA901',
        'Atlanta',
        'Amsterdam',
        95,
        '2025-03-13',
        '2025-03-14',
        650.00,
        85,
        0.1
    ),
    (
        'BB234',
        'Dallas',
        'Madrid',
        55,
        '2025-03-14',
        '2025-03-14',
        600.00,
        50,
        0.3
    ),
    (
        'CC567',
        'Seattle',
        'Paris',
        115,
        '2025-03-15',
        '2025-03-15',
        800.00,
        100,
        0.1
    ),
    (
        'DD890',
        'Boston',
        'London',
        45,
        '2025-03-16',
        '2025-03-16',
        650.00,
        40,
        0.1
    ),
    (
        'EE123',
        'New York',
        'Tokyo',
        2,
        '2025-03-17',
        '2025-03-17',
        299.99,
        8,
        0.5
    ),
    (
        'FF456',
        'Los Angeles',
        'London',
        150,
        '2025-03-18',
        '2025-03-18',
        750.00,
        120,
        0.1
    ),
    (
        'GG789',
        'Chicago',
        'Paris',
        100,
        '2025-03-19',
        '2025-03-19',
        600.00,
        90,
        0.2
    ),
    (
        'HH012',
        'Houston',
        'Sydney',
        50,
        '2025-03-20',
        '2025-03-21',
        1200.00,
        40,
        0.05
    ),
    (
        'II345',
        'Miami',
        'Rio de Janeiro',
        80,
        '2025-03-21',
        '2025-03-22',
        400.00,
        65,
        0.15
    ),
    (
        'JJ678',
        'San Francisco',
        'Hong Kong',
        120,
        '2025-03-22',
        '2025-03-23',
        900.00,
        100,
        0.1
    ),
    (
        'KK901',
        'Atlanta',
        'Berlin',
        90,
        '2025-03-23',
        '2025-03-24',
        550.00,
        75,
        0.25
    ),
    (
        'LL234',
        'Dallas',
        'Rome',
        70,
        '2025-03-24',
        '2025-03-25',
        650.00,
        55,
        0.2
    ),
    (
        'MM567',
        'Seattle',
        'Amsterdam',
        110,
        '2025-03-25',
        '2025-03-25',
        700.00,
        95,
        0.1
    ),
    (
        'NN890',
        'Boston',
        'Madrid',
        60,
        '2025-03-26',
        '2025-03-26',
        500.00,
        48,
        0.3
    ),
    (
        'OO123',
        'New York',
        'Paris',
        30,
        '2025-03-27',
        '2025-03-27',
        550.00,
        25,
        0.1
    ),
    (
        'PP456',
        'Los Angeles',
        'Tokyo',
        140,
        '2025-03-28',
        '2025-03-29',
        800.00,
        110,
        0.15
    ),
    (
        'QQ789',
        'Chicago',
        'London',
        90,
        '2025-03-29',
        '2025-03-30',
        650.00,
        80,
        0.2
    ),
    (
        'RR012',
        'Houston',
        'Sydney',
        40,
        '2025-03-30',
        '2025-03-31',
        1300.00,
        35,
        0.05
    ),
    (
        'SS345',
        'Miami',
        'Rio de Janeiro',
        70,
        '2025-03-31',
        '2025-04-01',
        450.00,
        60,
        0.15
    );