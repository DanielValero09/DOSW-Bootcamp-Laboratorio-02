package edu.dosw.lab.comportamiento.reto7;

public abstract class AbstractRoverCommand implements RoverCommand {
    private final String operator;
    private final String module;
    private final String action;
    private final String parameterSummary;

    protected AbstractRoverCommand(String operator, String module, String action, String parameterSummary) {
        this.operator = operator;
        this.module = module;
        this.action = action;
        this.parameterSummary = parameterSummary;
    }

    @Override
    public String getOperator() {
        return operator;
    }

    @Override
    public String getModule() {
        return module;
    }

    @Override
    public String getAction() {
        return action;
    }

    @Override
    public String getParameterSummary() {
        return parameterSummary;
    }
}
