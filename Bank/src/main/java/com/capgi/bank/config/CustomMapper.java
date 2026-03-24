import com.capgi.bank.entity.Account;
import com.capgi.bank.entity.dto.AccountDto;
import com.capgi.bank.entity.dto.AccountResponseDto;

public final class CustomMapper {

    private CustomMapper() {}

    public static AccountResponseDto mapAccountToResponseDto(Account account, AccountResponseDto dto) {
        dto.setAccountType(account.getAccountType());
        dto.setAccountId(account.getAccountId());
        dto.setAccountHolderName(account.getAccountHolderName());
        dto.setBalance(account.getBalance());
        return dto;
    }

    public static Account mapAccountDtoToAccount(AccountDto dto, Account account) {
        account.setAccountHolderName(dto.getAccountHolderName());
        account.setAccountType(dto.getAccountType());
        // account.setAccountSecureKey(dto.getAccountSecureKey());
        account.setHolderEmail(dto.getHolderEmail());
        account.setBalance(dto.getBalance());
        return account;
    }
}