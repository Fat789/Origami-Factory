package sopra.promo404.origami.model;



public class Views {
	public static class ViewCommon {
	}

	public static class ViewEtape extends ViewCommon {
	}
	
	public static class ViewEtapeWithOrigami extends ViewEtape {
	}
	
//
//	

	public static class ViewOrigami extends ViewCommon {
	}
	
	public static class ViewOrigamiWithEtapes extends ViewOrigami {
	}

//	
//	
	
	public static class ViewSecretaire extends ViewCommon {
	}

	public static class ViewSecretaireWithFileAttente extends ViewSecretaire {	
	}
	
//	
//	

	public static class ViewConsultation extends ViewCommon {
	}
	
	public static class ViewConsultationWithSpecialite extends ViewConsultation {
	}
	
//	
//	

	public static class ViewSpecialite extends ViewCommon {
	}
	
	
//	
//	
	
	public static class ViewSalle extends ViewCommon {
	}
	
	public static class ViewSalleWithMedecin extends ViewCommon {
	}
	

//
//

	public static class ViewFileAttente extends ViewCommon {
	}
	
	
	public static class ViewFileAttenteWithMedecin extends ViewFileAttente {
	}
	
	public static class ViewCategorie extends ViewCommon {
	}
}
