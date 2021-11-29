USE PETSHOP;
DELIMITER $$

CREATE PROCEDURE SP_INCLUIRPRODUTO_CLIENTE (IDPRODUTO INTEGER,
    CPF VARCHAR(11),
    DATACOMPRA DATETIME,
    QTDS INTEGER)
BEGIN
	INSERT INTO PRODUTO (IDPRODUTO, CPF, DATACOMPRA, QTDS) 
		  VALUES (IDPRODUTO, CPF, DATACOMPRA, QTDS);
END$$
DELIMITER ;