package fr.zbar.kata.pokerkata.model.hand.rule;

public enum RuleEnum {
    HIGH_CARD_RULE(new HighCardRule()),
    PAIR_RULE(new PairRule());

    private final Rule rule;

    RuleEnum(Rule rule) {
        this.rule = rule;
    }

    public Rule rule() {
        return rule;
    }
}
