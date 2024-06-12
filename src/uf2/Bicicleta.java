package uf2;

public class Bicicleta {
	private String codigo;
	private String fechaFabricacion;
	private double[] distancias;
	private boolean esElectrica;


	public Bicicleta(String codigo,String fechaFabricacion,double[] distancias2,boolean esElectrica ) {
		this.codigo=codigo;
		this.fechaFabricacion=fechaFabricacion;
		this.distancias=new double[4];
		this.esElectrica=esElectrica;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo=codigo;
	}
	public void setFechaFabricacion(String fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public double[] getDistancias() {
        return distancias;
    }

    public void setDistancias(double[] distancias) {
        this.distancias = distancias;
    }

    public boolean isEsElectrica() {
        return esElectrica;
    }

    public void setEsElectrica(boolean esElectrica) {
        this.esElectrica = esElectrica;
    }
    public double getDistanciaMedia() {
    	double suma=0;
    	for(double distancia:distancias) {
    		suma+= distancia;
    	}
    	return suma/ distancias.length;
    }
    public void showBici() {
    	System.out.println("Codigo"+ codigo);
    	System.out.println("Fecha de Fabricación: " + fechaFabricacion);
        System.out.println("Distancias: " + java.util.Arrays.toString(distancias));
        System.out.println("Es eléctrica: " + (esElectrica ? "Sí" : "No"));
        System.out.println("Distancia media: " + getDistanciaMedia());
    }
}
