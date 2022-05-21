-- Equipe: Zeus
-- Antonio Carlos Alves Guimarães Filho - RM85316
-- João Victor Marks de Farias Delgado - RM84596
-- Victor Chagas de Paiva - RM84577
-- Luís Fellipe Menedin Oliveira Balestrero - RM85490

-- Removendo tabelas


/*

DROP TABLE tb_caminhao CASCADE CONSTRAINTS;

DROP TABLE tb_carga CASCADE CONSTRAINTS;

DROP TABLE tb_cidade CASCADE CONSTRAINTS;

DROP TABLE tb_destinatario CASCADE CONSTRAINTS;

DROP TABLE tb_endereco_destinatario CASCADE CONSTRAINTS;

DROP TABLE tb_endereco_remetente CASCADE CONSTRAINTS;

DROP TABLE tb_estado CASCADE CONSTRAINTS;

DROP TABLE tb_iot_logger CASCADE CONSTRAINTS;

DROP TABLE tb_item CASCADE CONSTRAINTS;

DROP TABLE tb_itens_carga CASCADE CONSTRAINTS;

DROP TABLE tb_log_controle_portas CASCADE CONSTRAINTS;

DROP TABLE tb_log_localizacao CASCADE CONSTRAINTS;

DROP TABLE tb_log_parada CASCADE CONSTRAINTS;

DROP TABLE tb_log_peso CASCADE CONSTRAINTS;

DROP TABLE tb_log_temperatura CASCADE CONSTRAINTS;

DROP TABLE tb_motorista CASCADE CONSTRAINTS;

DROP TABLE tb_motorista_caminhao CASCADE CONSTRAINTS;

DROP TABLE tb_pais CASCADE CONSTRAINTS;

DROP TABLE tb_remetente CASCADE CONSTRAINTS;

DROP TABLE tb_status_envio CASCADE CONSTRAINTS;

DROP TABLE tb_transacao_envio CASCADE CONSTRAINTS;

*/

/* TABELAS */

CREATE TABLE tb_caminhao (
                             placa_caminhao_pk  VARCHAR2(7) NOT NULL,
                             chassi             VARCHAR2(17) NOT NULL,
                             marca              VARCHAR2(30) NOT NULL,
                             modelo             VARCHAR2(50) NOT NULL,
                             ano_modelo         NUMBER(4) NOT NULL,
                             cor                VARCHAR2(20) NOT NULL
);

ALTER TABLE tb_caminhao ADD CONSTRAINT tb_caminhao_pk PRIMARY KEY ( placa_caminhao_pk );

CREATE TABLE tb_carga (
                          id_carga_pk         NUMBER NOT NULL,
                          altura              FLOAT(5) NOT NULL,
                          largura             FLOAT(5) NOT NULL,
                          comprimento         FLOAT(5) NOT NULL,
                          fragil              CHAR(1) NOT NULL,
                          observacoes         VARCHAR2(300),
                          id_remetente_fk     NUMBER NOT NULL,
                          id_destinatario_fk  NUMBER NOT NULL
);

ALTER TABLE tb_carga ADD CONSTRAINT tb_carga_pk PRIMARY KEY ( id_carga_pk );

CREATE TABLE tb_cidade (
                           id_cidade_pk  NUMBER NOT NULL,
                           nm_cidade     VARCHAR2(60) NOT NULL,
                           id_estado_fk  NUMBER NOT NULL
);

ALTER TABLE tb_cidade ADD CONSTRAINT tb_cidade_pk PRIMARY KEY ( id_cidade_pk );

CREATE TABLE tb_destinatario (
                                 id_destinatario_pk  NUMBER NOT NULL,
                                 nm_fantasia         VARCHAR2(50) NOT NULL,
                                 razao_social        VARCHAR2(100) NOT NULL,
                                 cnpj_uk             VARCHAR2(14) NOT NULL,
                                 email               VARCHAR2(64) NOT NULL,
                                 tel                 VARCHAR2(14) NOT NULL
);

ALTER TABLE tb_destinatario ADD CONSTRAINT tb_destinatario_pk PRIMARY KEY ( id_destinatario_pk );

ALTER TABLE tb_destinatario ADD CONSTRAINT tb_destinatario_cnpj_uk UNIQUE ( cnpj_uk );

CREATE TABLE tb_endereco_destinatario (
                                          id_end_destinatario_pk  NUMBER NOT NULL,
                                          cep                     VARCHAR2(8) NOT NULL,
                                          nro                     VARCHAR2(7) NOT NULL,
                                          rua                     VARCHAR2(70) NOT NULL,
                                          bairro                  VARCHAR2(50) NOT NULL,
                                          complemento             VARCHAR2(100),
                                          id_destinatario_fk      NUMBER NOT NULL,
                                          id_cidade_fk            NUMBER NOT NULL
);

ALTER TABLE tb_endereco_destinatario ADD CONSTRAINT tb_endereco_destinatario_pk PRIMARY KEY ( id_end_destinatario_pk );

CREATE TABLE tb_endereco_remetente (
                                       id_end_remetente_pk  NUMBER NOT NULL,
                                       cep                  VARCHAR2(8) NOT NULL,
                                       nro                  VARCHAR2(7) NOT NULL,
                                       rua                  VARCHAR2(70) NOT NULL,
                                       bairro               VARCHAR2(50) NOT NULL,
                                       complemento          VARCHAR2(100),
                                       id_remetente_fk      NUMBER NOT NULL,
                                       id_cidade_fk         NUMBER NOT NULL
);

ALTER TABLE tb_endereco_remetente ADD CONSTRAINT tb_endereco_remetente_pk PRIMARY KEY ( id_end_remetente_pk );

CREATE TABLE tb_estado (
                           id_estado_pk  NUMBER NOT NULL,
                           nm_estado     VARCHAR2(60) NOT NULL,
                           uf            VARCHAR2(2) NOT NULL,
                           id_pais_fk    NUMBER(3) NOT NULL
);

ALTER TABLE tb_estado ADD CONSTRAINT tb_estado_pk PRIMARY KEY ( id_estado_pk );

CREATE TABLE tb_iot_logger (
                               id_iot_logger_pk  NUMBER NOT NULL,
                               vida_util         VARCHAR2(30) NOT NULL,
                               dt_fabricacao     DATE NOT NULL,
                               dt_importacao     DATE NOT NULL,
                               altura            FLOAT(5),
                               largura           FLOAT(5),
                               peso              FLOAT(10),
                               descricao         VARCHAR2(180)
);

ALTER TABLE tb_iot_logger ADD CONSTRAINT tb_iot_logger_pk PRIMARY KEY ( id_iot_logger_pk );

CREATE TABLE tb_item (
                         id_item_pk  NUMBER NOT NULL,
                         nm_item     VARCHAR2(50) NOT NULL,
                         preco       NUMBER(10, 2) NOT NULL,
                         peso        FLOAT(5) NOT NULL
);

ALTER TABLE tb_item ADD CONSTRAINT tb_item_pk PRIMARY KEY ( id_item_pk );

CREATE TABLE tb_itens_carga (
                                id_carga_pf     NUMBER NOT NULL,
                                id_item_pf      NUMBER NOT NULL,
                                qtd_item_carga  NUMBER NOT NULL
);

ALTER TABLE tb_itens_carga ADD CONSTRAINT tb_itens_carga_pk PRIMARY KEY ( id_carga_pf,
                                                                          id_item_pf );

CREATE TABLE tb_log_controle_portas (
                                        id_controle_portas_pk  NUMBER NOT NULL,
                                        abertura_em            TIMESTAMP NOT NULL,
                                        fechamento_em          TIMESTAMP NOT NULL,
                                        id_iot_logger_fk       NUMBER NOT NULL
);

ALTER TABLE tb_log_controle_portas ADD CONSTRAINT tb_log_portas_pk PRIMARY KEY ( id_controle_portas_pk );

CREATE TABLE tb_log_localizacao (
                                    id_localizacao_pk  NUMBER NOT NULL,
                                    coord_x            NUMBER(9, 6) NOT NULL,
                                    coord_y            NUMBER(9, 6) NOT NULL,
                                    registrada_em      TIMESTAMP DEFAULT CURRENT_TIMESTAMP AT TIME ZONE 'GMT',
                                    id_iot_logger_fk   NUMBER NOT NULL
);

ALTER TABLE tb_log_localizacao ADD CONSTRAINT tb_log_local_pk PRIMARY KEY ( id_localizacao_pk );

CREATE TABLE tb_log_parada (
                               id_parada_pk      NUMBER NOT NULL,
                               parada_em         TIMESTAMP NOT NULL,
                               retomada_em       TIMESTAMP NOT NULL,
                               coord_x_parada    NUMBER(9, 6) NOT NULL,
                               coord_y_parada    NUMBER(9, 6) NOT NULL,
                               id_iot_logger_fk  NUMBER NOT NULL
);

ALTER TABLE tb_log_parada ADD CONSTRAINT tb_log_parada_pk PRIMARY KEY ( id_parada_pk );

CREATE TABLE tb_log_peso (
                             id_peso_pk        NUMBER NOT NULL,
                             peso              FLOAT(10) NOT NULL,
                             registrado_em     TIMESTAMP DEFAULT CURRENT_TIMESTAMP AT TIME ZONE 'GMT',
                             id_iot_logger_fk  NUMBER NOT NULL
);

ALTER TABLE tb_log_peso ADD CONSTRAINT tb_log_peso_pk PRIMARY KEY ( id_peso_pk );

CREATE TABLE tb_log_temperatura (
                                    id_temperatura_pk  NUMBER NOT NULL,
                                    temperatura        FLOAT(5) NOT NULL,
                                    registrado_em      TIMESTAMP DEFAULT CURRENT_TIMESTAMP AT TIME ZONE 'GMT',
                                    id_iot_logger_fk   NUMBER NOT NULL
);

ALTER TABLE tb_log_temperatura ADD CONSTRAINT tb_log_temp_pk PRIMARY KEY ( id_temperatura_pk );

CREATE TABLE tb_motorista (
                              id_motorista_pk  NUMBER NOT NULL,
                              nm_completo      VARCHAR2(70) NOT NULL,
                              cnh_uk           NUMBER(11) NOT NULL,
                              tel              VARCHAR2(14) NOT NULL,
                              em_atividade     CHAR(1) NOT NULL
);

ALTER TABLE tb_motorista ADD CONSTRAINT tb_motorista_pk PRIMARY KEY ( id_motorista_pk );

ALTER TABLE tb_motorista ADD CONSTRAINT tb_motorista_cnh_uk UNIQUE ( cnh_uk );

CREATE TABLE tb_motorista_caminhao (
                                       id_motorista_pf    NUMBER NOT NULL,
                                       placa_caminhao_pf  VARCHAR2(7) NOT NULL,
                                       id_iot_logger_fk   NUMBER NOT NULL
);

ALTER TABLE tb_motorista_caminhao ADD CONSTRAINT tb_motorista_caminhao_pk PRIMARY KEY ( id_motorista_pf,
                                                                                        placa_caminhao_pf );

ALTER TABLE tb_motorista_caminhao ADD CONSTRAINT tb_mot_cam_iot_log_uk UNIQUE ( id_iot_logger_fk );

CREATE TABLE tb_pais (
                         id_pais_pk  NUMBER(3) NOT NULL,
                         nm_pais_uk  VARCHAR2(50) NOT NULL,
                         sg_pais_uk  VARCHAR2(2) NOT NULL
);

ALTER TABLE tb_pais ADD CONSTRAINT tb_pais_pk PRIMARY KEY ( id_pais_pk );

ALTER TABLE tb_pais ADD CONSTRAINT tb_pais_nome_uk UNIQUE ( nm_pais_uk );

ALTER TABLE tb_pais ADD CONSTRAINT tb_pais_sigla_uk UNIQUE ( sg_pais_uk );

CREATE TABLE tb_remetente (
                              id_remetente_pk  NUMBER NOT NULL,
                              nm_fantasia      VARCHAR2(50) NOT NULL,
                              razao_social     VARCHAR2(100) NOT NULL,
                              cnpj_uk          VARCHAR2(14) NOT NULL,
                              email            VARCHAR2(64) NOT NULL,
                              tel              VARCHAR2(14) NOT NULL
);

ALTER TABLE tb_remetente ADD CONSTRAINT tb_remetente_pk PRIMARY KEY ( id_remetente_pk );

ALTER TABLE tb_remetente ADD CONSTRAINT tb_remetente_cnpj_un UNIQUE ( cnpj_uk );

CREATE TABLE tb_status_envio (
                                 id_status_envio_pk  NUMBER NOT NULL,
                                 nm_status               VARCHAR2(20) NOT NULL
);

ALTER TABLE tb_status_envio ADD CONSTRAINT tb_status_pk PRIMARY KEY ( id_status_envio_pk );

CREATE TABLE tb_transacao_envio (
                                    id_transacao_envio_pk   NUMBER NOT NULL,
                                    iniciada_em             TIMESTAMP DEFAULT CURRENT_TIMESTAMP AT TIME ZONE 'GMT',
                                    finalizada_em           TIMESTAMP,
                                    id_status_transacao_fk  NUMBER NOT NULL,
                                    id_carga_fk             NUMBER NOT NULL,
                                    id_motorista_fk         NUMBER NOT NULL,
                                    placa_caminhao_fk       VARCHAR2(7) NOT NULL
);

ALTER TABLE tb_transacao_envio ADD CONSTRAINT tb_transacao_envio_pk PRIMARY KEY ( id_transacao_envio_pk );

-- Foreign Key's

ALTER TABLE tb_carga
    ADD CONSTRAINT tb_carga_tb_destinatario_fk FOREIGN KEY ( id_destinatario_fk )
        REFERENCES tb_destinatario ( id_destinatario_pk );

ALTER TABLE tb_carga
    ADD CONSTRAINT tb_carga_tb_remetente_fk FOREIGN KEY ( id_remetente_fk )
        REFERENCES tb_remetente ( id_remetente_pk );

ALTER TABLE tb_cidade
    ADD CONSTRAINT tb_cidade_tb_estado_fk FOREIGN KEY ( id_estado_fk )
        REFERENCES tb_estado ( id_estado_pk );

ALTER TABLE tb_endereco_destinatario
    ADD CONSTRAINT tb_end_dest_tb_cidade_fk FOREIGN KEY ( id_cidade_fk )
        REFERENCES tb_cidade ( id_cidade_pk );

ALTER TABLE tb_endereco_destinatario
    ADD CONSTRAINT tb_end_dest_tb_destinatario_fk FOREIGN KEY ( id_destinatario_fk )
        REFERENCES tb_destinatario ( id_destinatario_pk );

ALTER TABLE tb_endereco_remetente
    ADD CONSTRAINT tb_end_reme_tb_cidade_fk FOREIGN KEY ( id_cidade_fk )
        REFERENCES tb_cidade ( id_cidade_pk );

ALTER TABLE tb_endereco_remetente
    ADD CONSTRAINT tb_end_reme_tb_remetente_fk FOREIGN KEY ( id_remetente_fk )
        REFERENCES tb_remetente ( id_remetente_pk );

ALTER TABLE tb_estado
    ADD CONSTRAINT tb_estado_tb_pais_fk FOREIGN KEY ( id_pais_fk )
        REFERENCES tb_pais ( id_pais_pk );

ALTER TABLE tb_itens_carga
    ADD CONSTRAINT tb_itens_carga_tb_carga_fk FOREIGN KEY ( id_carga_pf )
        REFERENCES tb_carga ( id_carga_pk );

ALTER TABLE tb_itens_carga
    ADD CONSTRAINT tb_itens_carga_tb_item_fk FOREIGN KEY ( id_item_pf )
        REFERENCES tb_item ( id_item_pk );

ALTER TABLE tb_log_localizacao
    ADD CONSTRAINT tb_log_local_tb_iot_logger_fk FOREIGN KEY ( id_iot_logger_fk )
        REFERENCES tb_iot_logger ( id_iot_logger_pk );

ALTER TABLE tb_log_parada
    ADD CONSTRAINT tb_log_parada_tb_iot_logger_fk FOREIGN KEY ( id_iot_logger_fk )
        REFERENCES tb_iot_logger ( id_iot_logger_pk );

ALTER TABLE tb_log_peso
    ADD CONSTRAINT tb_log_peso_tb_iot_logger_fk FOREIGN KEY ( id_iot_logger_fk )
        REFERENCES tb_iot_logger ( id_iot_logger_pk );

ALTER TABLE tb_log_controle_portas
    ADD CONSTRAINT tb_log_portas_tb_iot_logger_fk FOREIGN KEY ( id_iot_logger_fk )
        REFERENCES tb_iot_logger ( id_iot_logger_pk );

ALTER TABLE tb_log_temperatura
    ADD CONSTRAINT tb_log_temp_tb_iot_logger_fk FOREIGN KEY ( id_iot_logger_fk )
        REFERENCES tb_iot_logger ( id_iot_logger_pk );

ALTER TABLE tb_motorista_caminhao
    ADD CONSTRAINT tb_mot_cam_tb_caminhao_fk FOREIGN KEY ( placa_caminhao_pf )
        REFERENCES tb_caminhao ( placa_caminhao_pk );

ALTER TABLE tb_motorista_caminhao
    ADD CONSTRAINT tb_mot_cam_tb_iot_logger_fk FOREIGN KEY ( id_iot_logger_fk )
        REFERENCES tb_iot_logger ( id_iot_logger_pk );

ALTER TABLE tb_motorista_caminhao
    ADD CONSTRAINT tb_mot_cam_tb_motorista_fk FOREIGN KEY ( id_motorista_pf )
        REFERENCES tb_motorista ( id_motorista_pk );

ALTER TABLE tb_transacao_envio
    ADD CONSTRAINT tb_trans_envio_tb_carga_fk FOREIGN KEY ( id_carga_fk )
        REFERENCES tb_carga ( id_carga_pk );

ALTER TABLE tb_transacao_envio
    ADD CONSTRAINT tb_trans_envio_tb_mot_cam_fk FOREIGN KEY ( id_motorista_fk,
                                                              placa_caminhao_fk )
        REFERENCES tb_motorista_caminhao ( id_motorista_pf,
                                           placa_caminhao_pf );

ALTER TABLE tb_transacao_envio
    ADD CONSTRAINT tb_trans_envio_tb_status_fk FOREIGN KEY ( id_status_transacao_fk )
        REFERENCES tb_status_envio ( id_status_envio_pk );

-- Sequences
CREATE sequence motorista_seq nocache;
