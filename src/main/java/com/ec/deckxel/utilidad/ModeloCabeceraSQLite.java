package com.ec.deckxel.utilidad;

public class ModeloCabeceraSQLite {
	
	 /*CAMOPOS PARA ENVIO */
	private String COLUMN_NAME_IDUSUARIO;
	private String COLUMN_NAME_FECHA;
    private String CEDULA;
    private String NOMBRECLI;
    private String CORREOCLI;
    private String CORREO;
    private String MOVIL;
    private String DIRECCION;
    private String TOTAL;
    private String SECUENCIALUNICO; 

    
    
    
    
    public ModeloCabeceraSQLite(String cOLUMN_NAME_IDUSUARIO, String cOLUMN_NAME_FECHA, String cEDULA, String nOMBRECLI,
			String cORREOCLI, String cORREO, String mOVIL, String dIRECCION, String tOTAL, String sECUENCIALUNICO) {
		super();
		COLUMN_NAME_IDUSUARIO = cOLUMN_NAME_IDUSUARIO;
		COLUMN_NAME_FECHA = cOLUMN_NAME_FECHA;
		CEDULA = cEDULA;
		NOMBRECLI = nOMBRECLI;
		CORREOCLI = cORREOCLI;
		CORREO = cORREO;
		MOVIL = mOVIL;
		DIRECCION = dIRECCION;
		TOTAL = tOTAL;
		SECUENCIALUNICO = sECUENCIALUNICO;
	}



	public ModeloCabeceraSQLite() {
		super();
	}

    
    
	public String getCOLUMN_NAME_IDUSUARIO() {
		return COLUMN_NAME_IDUSUARIO;
	}



	public void setCOLUMN_NAME_IDUSUARIO(String cOLUMN_NAME_IDUSUARIO) {
		COLUMN_NAME_IDUSUARIO = cOLUMN_NAME_IDUSUARIO;
	}



	public String getCOLUMN_NAME_FECHA() {
		return COLUMN_NAME_FECHA;
	}

	public void setCOLUMN_NAME_FECHA(String cOLUMN_NAME_FECHA) {
		COLUMN_NAME_FECHA = cOLUMN_NAME_FECHA;
	}

	/*DATOS DEL CLIENT*/
   	public String getCEDULA() {
   		return CEDULA;
   	}

   	public void setCEDULA(String cEDULA) {
   		CEDULA = cEDULA;
   	}

   	public String getNOMBRECLI() {
   		return NOMBRECLI;
   	}

   	public void setNOMBRECLI(String nOMBRECLI) {
   		NOMBRECLI = nOMBRECLI;
   	}

   	public String getCORREOCLI() {
   		return CORREOCLI;
   	}

   	public void setCORREOCLI(String cORREOCLI) {
   		CORREOCLI = cORREOCLI;
   	}

   	public String getCORREO() {
   		return CORREO;
   	}

   	public void setCORREO(String cORREO) {
   		CORREO = cORREO;
   	}

   	public String getMOVIL() {
   		return MOVIL;
   	}

   	public void setMOVIL(String mOVIL) {
   		MOVIL = mOVIL;
   	}

   	public String getDIRECCION() {
   		return DIRECCION;
   	}

   	public void setDIRECCION(String dIRECCION) {
   		DIRECCION = dIRECCION;
   	}

	public String getTOTAL() {
		return TOTAL;
	}

	public void setTOTAL(String tOTAL) {
		TOTAL = tOTAL;
	}



	public String getSECUENCIALUNICO() {
		return SECUENCIALUNICO;
	}



	public void setSECUENCIALUNICO(String sECUENCIALUNICO) {
		SECUENCIALUNICO = sECUENCIALUNICO;
	}



       

}
