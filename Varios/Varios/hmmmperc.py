import hashlib
import time
import decimal

def main():
    with open("Varios/Varios/hmmm.png", "rb") as f:
        #measure execution time
        start=time.time()
        data = f.read()
        hash = hashlib.blake2s(data).digest()
        end=time.time()
        print("Time taken to compute hash:", end - start, "seconds")
        print("Hash of hmmm.png:", hash)
        num = int.from_bytes(hash, 'big')
        print("Integer value:", num)
        normalized = num / ((1 << 256) - 1)
        print("Normalized value:", normalized)

        ##print 6 decimals
        print("Normalized value (6 decimals): {:.6f}%".format(normalized*100))

        """
        # Using decimal for higher precision
        decimal.getcontext().prec = 69422
        dnum = decimal.Decimal(num)
        dmax = decimal.Decimal((1 << 256) - 1)
        dnormalized = dnum / dmax*100
        print("Decimal Normalized value:", dnormalized)
        """

if __name__ == "__main__":
    main()