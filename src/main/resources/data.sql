INSERT INTO store(store_id, store_name)
VALUES (1, 'Loja Pinheiros'),
       (2, 'Loja Jardins'),
       (3, 'Loja Moema');
INSERT INTO service_area(service_area_id, service_area_start_range, service_area_end_range, store_id)
VALUES (1, 10000000, 20000000, 1),
       (2, 20000001, 30000000, 1),
       (3, 30000001, 40000000, 2),
       (4, 40000001, 50000000, 2);
