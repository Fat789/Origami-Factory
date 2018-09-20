package sopra.promo404.origami.model;

public enum Niveau {
	facile("FACILE"), moyen("MOYEN"), difficile("DIFFICILE"), impossible("IMPOSSIBLE");

	private final String label;

	private Niveau(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
