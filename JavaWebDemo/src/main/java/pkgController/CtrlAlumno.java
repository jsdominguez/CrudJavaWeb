package pkgController;
import pkgDao.DaoAlumno;
import pkgModel.MdlAlumno;
import pkgOperciones.Opalumno;

public class CtrlAlumno {
		
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
