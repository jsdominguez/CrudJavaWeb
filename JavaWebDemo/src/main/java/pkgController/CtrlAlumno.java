package pkgController;
import pkgDao.DaoAlumno;
import pkgModel.MdlAlumno;
import pkgOperciones.Opalumno;

public class CtrlAlumno {
	
	public void ctrlInciar() {
		Opalumno.OpMostrarMenu();
		this.ctrlSeleccionarOpcion();
	}
	
	public void ctrlSeleccionarOpcion() {
		int opcElegida = Opalumno.opSeleccionarOpcion();
		this.ctrlEjecutarAccion(opcElegida);
	}
	
	public void ctrlEjecutarAccion(int opcElegida) {
		switch(opcElegida) {
			case 0:
				System.exit(0);
				break;
			case 1:
				this.ctlrRegistrarAlumno();
			break;
			case 2:
				this.ctrlListarAlumno();
			break;
			case 3:
				this.ctrlEditarAlumno();
			break;
			case 4:
				this.ctrlEliminarAlumnoId();
				break;
			case 5:
				this.ctlrBuscarAlumnoId();
				break;
			default:
				System.out.println("\n[X] OPCION INCORRECTA [X]\n");
				this.ctrlSeleccionarOpcion();
				break;
		}
		this.ctrlInciar();
	}
	
	public void ctlrRegistrarAlumno() {
		MdlAlumno objAlumno = Opalumno.opSolicitarDatos(0);
		DaoAlumno objDaoAlumno = new DaoAlumno();
		objDaoAlumno.daoRegistrarAlumno(objAlumno);
	}
	
	public void ctlrBuscarAlumnoId() {
		int codigo = Opalumno.opSolicitarIdAlumno();
		DaoAlumno objDaoAlumno = new DaoAlumno();
		objDaoAlumno.daoBuscarAlumnoId(codigo);
	}
	
	public void ctrlEditarAlumno() {
		int codigo = Opalumno.opSolicitarIdAlumno();
		DaoAlumno objDaoAlumno = new DaoAlumno();
		if(objDaoAlumno.daoBuscarAlumnoId(codigo)){
			MdlAlumno objAlumno = Opalumno.opSolicitarDatos(codigo);
			objDaoAlumno.daoEditarAlumno(objAlumno);
		}
	}
	
	public void ctrlEliminarAlumnoId() {
		int codigo = Opalumno.opSolicitarIdAlumno();
		DaoAlumno objDaoAlumno = new DaoAlumno();
		objDaoAlumno.daoEliminarAlumnoId(codigo);
	}
	
	public void ctrlListarAlumno() {
		DaoAlumno objDaoAlumno = new DaoAlumno();
		objDaoAlumno.daoListarAlumno();
	}
}
