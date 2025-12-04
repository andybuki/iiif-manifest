# Configuration Guide

This document provides detailed information about configuring the IIIF Manifest Builder application.

## Configuration Methods

The application can be configured through multiple methods, listed in order of precedence:

1. **Environment Variables** (highest priority)
2. **application-local.properties** (local overrides, not committed to git)
3. **application.properties** (default configuration)
4. **CollectionConfig.java** (hardcoded fallbacks)

## Environment Variables

Create a `.env` file in the project root (copy from `.env.example`):

```bash
# Base path for all collection folders
IIIF_COLLECTIONS_BASE_PATH=/path/to/collections

# IIIF Image Server Base URL
IIIF_SERVER_BASE_URL=https://iiif-content.crossasia.org/xasia/

# Fedora Repository Base URL
FEDORA_BASE_URL=https://itr02.crossasia.org/fcrepo/rest
```

### Available Environment Variables

| Variable | Description | Default |
|----------|-------------|---------|
| `IIIF_COLLECTIONS_BASE_PATH` | Root directory for all collections | `C:/Collections` |
| `IIIF_SERVER_BASE_URL` | IIIF Image API server URL | `https://iiif-content.crossasia.org/xasia/` |
| `FEDORA_BASE_URL` | Fedora repository base URL | `https://itr02.crossasia.org/fcrepo/rest` |

## Application Properties

### Logging Configuration

```properties
# Log levels: TRACE, DEBUG, INFO, WARN, ERROR
logging.level.root=INFO
logging.level.org.crossasia=DEBUG

# Console output pattern
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %msg%n

# Log file location
logging.file.name=logs/iiif-manifest-builder.log
```

### Collection Paths

```properties
# Base path for collections (can be overridden by environment variable)
iiif.collections.base.path=${IIIF_COLLECTIONS_BASE_PATH:C:/Collections}
```

### IIIF Server Configuration

```properties
# IIIF Image Server
iiif.server.base.url=${IIIF_SERVER_BASE_URL:https://iiif-content.crossasia.org/xasia/}

# Connection timeout in milliseconds (default: 10 seconds)
iiif.server.connection.timeout=10000

# Read timeout in milliseconds (default: 10 seconds)
iiif.server.read.timeout=10000
```

### Processing Options

```properties
# Skip files with errors and continue processing
app.processing.skip.errors=true

# Enable parallel processing (experimental)
app.processing.parallel=false
```

## Collection Configuration

Collections are configured in `CollectionConfig.java`. Each collection has:

### Collection Properties

| Property | Description | Example |
|----------|-------------|---------|
| `collectionName` | Unique identifier | `"dtab"` |
| `manifestCollection` | Manifest URL segment | `"dtab+"` |
| `dataUrl` | Fedora data URL | `https://itr02.crossasia.org/fcrepo/rest/dtab` |
| `collectionUrl` | Collection metadata URL | `https://itr02.crossasia.org/fcrepo/rest/dtab/collection` |
| `partOf` | IIIF collection link | `https://iiif.crossasia.org/s/dtab/` |
| `label` | Display name | `"Tibetan Documents Archive"` |
| `summary` | Collection description | `"Archive of Tibetan documents..."` |
| `requiredStatement` | Rights statement | `"Licensed under CC BY-NC-SA 4.0"` |
| `iiifBaseUrl` | IIIF server URL | `https://iiif-content.crossasia.org/xasia/` |
| `resultFolder` | Input JSON folder | `C:/Collections/Dtab/result/` |
| `manifestsFolder` | Output folder | `C:/Collections/Dtab/manifests/` |
| `idType` | ID format (STRING/INTEGER) | `IdType.INTEGER` |
| `language` | Primary language | `"en"` |

### Adding a New Collection

1. **Add enum entry** in `CollectionConfig.java`:

```java
NEW_COLLECTION(
    "new-collection",           // collectionName
    "new-collection+",          // manifestCollection
    "https://...",              // dataUrl
    "https://...",              // collectionUrl
    "https://...",              // partOf
    "Collection Display Name",  // label
    "Collection description",   // summary
    "Rights statement",         // requiredStatement
    "https://iiif-server/",     // iiifBaseUrl
    "C:/Collections/New/result/",      // resultFolder
    "C:/Collections/New/manifests/",   // manifestsFolder
    IdType.STRING,              // idType
    "en"                        // language
)
```

2. **Create metadata processor** (if needed):

Create a new class in `org.crossasia.manifest.attributes`:

```java
public class NewCollectionAttributes extends BaseCollectionAttributes {
    // Add collection-specific fields
    private String customField;

    // Getters and setters
}
```

3. **Add to AttributeProcessor enum** (if custom metadata needed):

```java
case NEW_COLLECTION:
    return new NewCollectionProcessor();
```

## Directory Structure

Expected folder structure:

```
Collections/
├── Dtab/
│   ├── result/          # Input JSON files
│   └── manifests/       # Output IIIF manifests
├── Kahlen/
│   ├── result/
│   └── manifests/
├── Turfan/
│   ├── result/
│   └── manifests/
└── ...
```

## Local Development Configuration

For local development, create `application-local.properties` (this file is in `.gitignore`):

```properties
# Local paths (Unix/Mac)
iiif.collections.base.path=/Users/yourname/Projects/collections

# or Windows
# iiif.collections.base.path=D:/Projects/collections

# Local IIIF server (if running locally)
# iiif.server.base.url=http://localhost:8182/iiif/2/

# Verbose logging for debugging
logging.level.org.crossasia=TRACE
logging.level.org.crossasia.manifest.canvas=TRACE
```

## Docker Configuration

When running in Docker, use environment variables:

```dockerfile
ENV IIIF_COLLECTIONS_BASE_PATH=/app/collections
ENV IIIF_SERVER_BASE_URL=https://iiif-content.crossasia.org/xasia/
ENV FEDORA_BASE_URL=https://itr02.crossasia.org/fcrepo/rest
```

Or with docker-compose:

```yaml
version: '3.8'
services:
  iiif-manifest-builder:
    image: iiif-manifest-builder:latest
    environment:
      - IIIF_COLLECTIONS_BASE_PATH=/app/collections
      - IIIF_SERVER_BASE_URL=https://iiif-content.crossasia.org/xasia/
      - FEDORA_BASE_URL=https://itr02.crossasia.org/fcrepo/rest
    volumes:
      - ./collections:/app/collections
```

## Troubleshooting Configuration Issues

### Configuration Not Loading

**Problem**: Changes to configuration are not reflected

**Solutions**:
1. Verify file location: `src/main/resources/application.properties`
2. Check for typos in property names
3. Ensure `.env` file is in project root (not in `src/`)
4. Rebuild project: `mvn clean package`

### Path Issues

**Problem**: "Input directory does not exist"

**Solutions**:
1. Check path separators (use `/` for cross-platform compatibility)
2. Use absolute paths instead of relative paths
3. Verify environment variable is set: `echo $IIIF_COLLECTIONS_BASE_PATH`
4. Check folder permissions

### IIIF Server Connection Issues

**Problem**: "Image dimensions not found"

**Solutions**:
1. Test server URL in browser: `https://server/collection+id+position/info.json`
2. Check network connectivity
3. Increase timeouts in `application.properties`:
   ```properties
   iiif.server.connection.timeout=30000
   iiif.server.read.timeout=30000
   ```
4. Verify server is accessible from your network

## Configuration Validation

To validate your configuration, run:

```bash
mvn test -Dtest=ConfigurationTest
```

This will check:
- All required environment variables are set
- Paths exist and are writable
- IIIF server is accessible
- Fedora repository is accessible (if configured)

## Best Practices

1. **Never commit** `.env` or `application-local.properties` files
2. **Use environment variables** for deployment-specific values
3. **Document** custom collection configurations
4. **Test** configuration changes in development before deploying
5. **Backup** collection data before changing paths
6. **Monitor** logs for configuration-related warnings

## Support

For configuration help:
1. Check logs: `logs/iiif-manifest-builder.log`
2. Review this documentation
3. Check GitHub issues
4. Contact the project maintainer:
   - **Andrey Buchmann** - Andrey.Buchmann@sbb.spk-berlin.de
   - Staatsbibliothek zu Berlin - Preußischer Kulturbesitz
