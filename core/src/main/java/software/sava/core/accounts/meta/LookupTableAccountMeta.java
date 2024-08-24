package software.sava.core.accounts.meta;

import software.sava.core.accounts.PublicKey;
import software.sava.core.accounts.lookup.AccountIndexLookupTableEntry;
import software.sava.core.accounts.lookup.AddressLookupTable;

import java.util.Collection;

import static software.sava.core.accounts.lookup.AddressLookupTable.LOOKUP_TABLE_MAX_ADDRESSES;

public interface LookupTableAccountMeta {

  static LookupTableAccountMeta createMeta(final AddressLookupTable lookupTable, final int maxNumAccounts) {
    return new TableAccountMeta(lookupTable, new AccountMeta[maxNumAccounts]);
  }

  static LookupTableAccountMeta[] createMetas(final AddressLookupTable[] lookupTables, final int maxNumAccounts) {
    final LookupTableAccountMeta[] tableAccountMetas = new LookupTableAccountMeta[lookupTables.length];
    for (int i = 0; i < lookupTables.length; ++i) {
      tableAccountMetas[i] = createMeta(lookupTables[i], maxNumAccounts);
    }
    return tableAccountMetas;
  }

  static LookupTableAccountMeta[] createMetas(final Collection<AddressLookupTable> lookupTables, final int maxNumAccounts) {
    final int numTables = lookupTables.size();
    final LookupTableAccountMeta[] tableAccountMetas = new LookupTableAccountMeta[numTables];
    int i = 0;
    for (final var lookupTable : lookupTables) {
      tableAccountMetas[i++] = createMeta(lookupTable, maxNumAccounts);
    }
    return tableAccountMetas;
  }

  static LookupTableAccountMeta createMeta(final AddressLookupTable lookupTable) {
    return new TableAccountMeta(lookupTable, new AccountMeta[LOOKUP_TABLE_MAX_ADDRESSES]);
  }

  static LookupTableAccountMeta[] createMetas(final AddressLookupTable[] lookupTables) {
    return createMetas(lookupTables, LOOKUP_TABLE_MAX_ADDRESSES);
  }

  static LookupTableAccountMeta[] createMetas(final Collection<AddressLookupTable> lookupTables) {
    return createMetas(lookupTables, LOOKUP_TABLE_MAX_ADDRESSES);
  }

  AddressLookupTable lookupTable();

  int indexOf(final PublicKey publicKey);

  byte indexOfOrThrow(final PublicKey publicKey);

  int addReverseLookupEntries(final AccountIndexLookupTableEntry[] accountIndexLookupTable, int out);

  void addAccount(final AccountMeta account);

  void reset();

  int serializationLength();

  int serialize(final byte[] out, int i);
}
