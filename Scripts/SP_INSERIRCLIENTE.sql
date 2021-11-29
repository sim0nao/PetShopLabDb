USE PETSHOP;
DELIMITER $$

CREATE PROCEDURE SP_INCLUIRCLIENTE (CPF VARCHAR(11) ,
	NOMECLI VARCHAR(50),
    TELEFONE VARCHAR (20),
    ENDERECO VARCHAR (100),
    DATANASC DATETIME,
    SEXO CHAR(1))
BEGIN
	INSERT INTO CLIENTE (CPF, NOMECLI, TELEFONE, ENDERECO, DATANASC, SEXO) 
		  VALUES (CPF, NOMECLI, TELEFONE, ENDERECO, DATANASC, SEXO);
END$$
DELIMITER ;