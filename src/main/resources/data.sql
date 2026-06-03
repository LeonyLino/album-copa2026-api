--INSERT INTO tb_users (identityuuid, created_at, updated_at, email, password) VALUES
 --   ( RANDOM_UUID(), CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'lino@email.com', '$2a$10$Mwp/xeDKTCPlX3SARBZgx.S0UlAioBBb/bmsuzBQ7J.5hEBPJbJ06');




INSERT INTO tb_users (identityuuid, email, password) VALUES
    ( gen_random_uuid(), 'lino@email.com', '$2a$10$Mwp/xeDKTCPlX3SARBZgx.S0UlAioBBb/bmsuzBQ7J.5hEBPJbJ06');