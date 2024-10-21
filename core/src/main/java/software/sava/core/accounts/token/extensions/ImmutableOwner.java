package software.sava.core.accounts.token.extensions;

import software.sava.core.accounts.token.ExtensionType;

public record ImmutableOwner() implements TokenExtension {

  public static final ImmutableOwner INSTANCE = new ImmutableOwner();

  @Override
  public ExtensionType extensionType() {
    return ExtensionType.ImmutableOwner;
  }

  @Override
  public int l() {
    return 0;
  }

  @Override
  public int write(final byte[] data, final int offset) {
    return 0;
  }
}
