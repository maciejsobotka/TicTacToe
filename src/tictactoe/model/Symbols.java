package tictactoe.model;

public enum Symbols {
	Knot("O"),
	Cross("X");
	
    private final String value;

    Symbols(String value) {
        this.value = value;
    }

	@Override
	public String toString()
	{
		return value;
	}
}
