# Security Policy

## Supported Versions

| Version | Supported          |
| ------- | ------------------ |
| 1.x     | :white_check_mark: |
| < 1.0   | :x:                |

## Reporting a Vulnerability

If you discover a security vulnerability in the IIIF Manifest Builder, please report it by:

1. **Do NOT** open a public GitHub issue
2. Email the security contact: **Andrey.Buchmann@sbb.spk-berlin.de**
3. Include:
   - Description of the vulnerability
   - Steps to reproduce
   - Potential impact
   - Suggested fix (if any)

We will respond within 48 hours and work with you to address the issue.

## Security Best Practices

### Dependency Management

We take dependency security seriously and have implemented several measures:

1. **Regular Updates**: Dependencies are reviewed and updated monthly
2. **Vulnerability Scanning**: Automated OWASP Dependency Check runs on every build
3. **Version Pinning**: All dependencies have explicit version numbers

### Running Security Scans

#### OWASP Dependency Check

Run a full dependency vulnerability scan:

```bash
mvn dependency-check:check
```

This will:
- Download the latest CVE database (first run may take 10-15 minutes)
- Scan all dependencies for known vulnerabilities
- Generate reports in `target/dependency-check-report.html`
- **Fail the build** if any vulnerability has CVSS >= 7.0 (High severity)

#### View Report

After running the scan:

```bash
# Open HTML report
open target/dependency-check-report.html

# Or view JSON report
cat target/dependency-check-report.json
```

#### Update CVE Database

The CVE database is cached. To force an update:

```bash
mvn dependency-check:purge
mvn dependency-check:check
```

#### Bypass Scan (Not Recommended)

If you need to bypass the scan temporarily (e.g., during development):

```bash
mvn clean install -DskipTests -Ddependency-check.skip=true
```

### CI/CD Integration

The dependency check is configured to run automatically:

```bash
# In your CI/CD pipeline
mvn clean verify
```

This ensures every build is scanned for vulnerabilities.

### Known Issues and Suppressions

If a vulnerability is a false positive or has no fix available, you can suppress it:

1. Create `dependency-check-suppressions.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<suppressions xmlns="https://jeremylong.github.io/DependencyCheck/dependency-suppression.1.3.xsd">
    <suppress>
        <notes>False positive - not applicable to our usage</notes>
        <cve>CVE-2024-XXXXX</cve>
    </suppress>
</suppressions>
```

2. Update `pom.xml` to reference it (already configured)

## Security Checklist for Developers

When contributing code:

- [ ] No hardcoded secrets, passwords, or API keys
- [ ] Input validation for all external data
- [ ] Proper error handling (no sensitive data in error messages)
- [ ] Use parameterized queries (if adding database access)
- [ ] Validate and sanitize file paths
- [ ] Use HTTPS for all external connections
- [ ] No use of insecure functions (e.g., eval, exec)
- [ ] Dependencies are from trusted sources
- [ ] Run `mvn dependency-check:check` before committing

## Common Vulnerabilities (OWASP Top 10)

Our mitigations:

### A01: Broken Access Control
- File paths are validated
- Configuration files use environment variables
- No direct file system access from user input

### A02: Cryptographic Failures
- HTTPS enforced for all IIIF server connections
- No sensitive data stored in plaintext
- Environment variables for secrets

### A03: Injection
- JSON parsing with proper error handling
- No SQL injection risk (no database in current version)
- File paths validated against directory traversal

### A04: Insecure Design
- Clear separation of concerns
- Configuration externalized
- Builder patterns for complex objects

### A05: Security Misconfiguration
- Explicit dependency versions
- Secure defaults in configuration
- Deprecation warnings enabled

### A06: Vulnerable Components
- **OWASP Dependency Check** runs on every build
- Regular dependency updates
- Automated vulnerability scanning

### A07: Authentication Failures
- Not applicable (no authentication in current version)

### A08: Software and Data Integrity
- Maven Central for dependencies
- Checksums verified automatically
- Version control for all code

### A09: Security Logging Failures
- Comprehensive logging with SLF4J
- No sensitive data in logs
- Proper error handling and logging

### A10: Server-Side Request Forgery
- URL validation before requests
- Protocol whitelist (HTTP/HTTPS only)
- Timeout configuration on all requests

## Security Updates

### Recent Security Improvements (Version 1.0)

- ✅ Updated `org.json` from 20170516 to 20231013 (fixed CVE-2022-45688)
- ✅ Added OWASP Dependency Check plugin
- ✅ Updated all dependencies to latest stable versions
- ✅ Added URL validation and HTTP response checking
- ✅ Implemented proper logging (no sensitive data exposure)
- ✅ Added connection and read timeouts

### Upcoming Security Enhancements

- [ ] Add input sanitization library
- [ ] Implement rate limiting for IIIF server requests
- [ ] Add digital signature verification for manifests
- [ ] Implement audit logging

## Dependency Inventory

Critical dependencies and their security status:

| Dependency | Version | Last Updated | Security Notes |
|------------|---------|--------------|----------------|
| Spring Boot | 3.2.10 | 2024-12 | Active support |
| org.json | 20231013 | 2024-12 | Security fix applied |
| json-path | 2.9.0 | 2024-12 | Up to date |
| JUnit | 5.10.3 | 2024-12 | Test only |

Run `mvn dependency:tree` to see full dependency tree.

## Contact

For security concerns:
- **Security Contact**: Andrey Buchmann - Andrey.Buchmann@sbb.spk-berlin.de
- **General Issues**: GitHub Issues
- **Urgent Vulnerabilities**: Andrey.Buchmann@sbb.spk-berlin.de (mark as URGENT in subject)

## Acknowledgments

We appreciate responsible disclosure of security vulnerabilities. Contributors who report valid security issues will be acknowledged (with permission) in:
- Release notes
- CHANGELOG.md
- This security document

## References

- [OWASP Top 10](https://owasp.org/www-project-top-ten/)
- [OWASP Dependency Check](https://owasp.org/www-project-dependency-check/)
- [National Vulnerability Database](https://nvd.nist.gov/)
- [CVE Database](https://cve.mitre.org/)
