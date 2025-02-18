package software.sava.core.tx;

import static software.sava.core.tx.Transaction.VERSIONED_BIT_MASK;

public enum TransactionVersion {
    LEGACY("legacy", VERSIONED_BIT_MASK),
    V0("0", 0);

    public final String versionIdentifier;
    public final int version;

    TransactionVersion(String versionIdentifier, int version) {
        this.versionIdentifier = versionIdentifier;
        this.version = version;
    }

    public static TransactionVersion fromVersion(int version) {
        return switch (version) {
            case VERSIONED_BIT_MASK -> LEGACY;
            case 0 -> V0;
            default -> null;
        };
    }
}
