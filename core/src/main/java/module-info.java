module software.sava.core {
  requires org.bouncycastle.provider;

  exports software.sava.core.accounts;
  exports software.sava.core.accounts.lookup;
  exports software.sava.core.accounts.meta;
  exports software.sava.core.accounts.token;
  exports software.sava.core.borsh;
  exports software.sava.core.crypto;
  exports software.sava.core.crypto.bip32;
  exports software.sava.core.crypto.ed25519;
  exports software.sava.core.encoding;
  exports software.sava.core.programs;
  exports software.sava.core.rpc;
  exports software.sava.core.tx;
  exports software.sava.core.util;
}
