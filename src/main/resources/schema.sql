CREATE TABLE store
(
    store_id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    store_name VARCHAR(255)
);
CREATE TABLE service_area
(
    service_area_id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    service_area_end_range   BIGINT,
    service_area_start_range BIGINT,
    store_id                 BIGINT,
    CONSTRAINT fk_store_id FOREIGN KEY (store_id) REFERENCES store (store_id)
)
