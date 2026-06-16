
    alter table if exists auto 
       drop constraint if exists fk_auto_veicolo;

    alter table if exists bici 
       drop constraint if exists fk_bici_veicolo;

    alter table if exists moto 
       drop constraint if exists fk_moto_veicolo;

    alter table if exists veicolo 
       drop constraint if exists FK1ffq24yvhb1147soqdmhcrr75;

    alter table if exists veicolo 
       drop constraint if exists FKhawc18rfxiebdktlu7293kpom;

    alter table if exists veicolo 
       drop constraint if exists FKmtqpek2bi3wm860ce0avhtqyp;

    drop table if exists auto cascade;

    drop table if exists bici cascade;

    drop table if exists categoria cascade;

    drop table if exists colore cascade;

    drop table if exists messaggi_sistema cascade;

    drop table if exists moto cascade;

    drop table if exists tipo_alimentazione cascade;

    drop table if exists veicolo cascade;
