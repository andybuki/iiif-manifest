# IIIF Manifest Builder

A Java application for creating IIIF 3.0 Presentation API manifests from JSON source files.

## Overview

This application converts JSON files into IIIF 3.0 compliant manifests, supporting multiple collections with different metadata schemas. The builder supports:

- Multiple collection types (DTAB, Kahlen, TAP, Turfan, Sugawara, and more)
- Multi-language metadata with automatic script detection
- Integration with IIIF Image API servers
- Flexible configuration via properties and environment variables

## Features

- **IIIF 3.0 Compliant**: Generates manifests following the IIIF Presentation API 3.0 specification
- **Multi-Collection Support**: Configure and process multiple collections with different metadata requirements
- **Language Detection**: Automatic detection and tagging of Chinese, Japanese, Korean, Thai, Tibetan, and Arabic text
- **Flexible Configuration**: Environment variables and properties files for easy deployment
- **Robust Error Handling**: Comprehensive logging and error recovery
- **Batch Processing**: Process entire folders of JSON files at once

## Requirements

- Java 17 or higher
- Maven 3.6+
- Access to a IIIF Image Server (e.g., NGCS-Chula)
- Fedora Repository (optional, for storage)

## Quick Start

### 1. Clone and Build

```bash
git clone <repository-url>
cd iiif-manifest
mvn clean install
```

### 2. Configure

Copy the example environment file and update with your settings:

```bash
cp .env.example .env
```

Edit `.env` with your configuration:
```properties
IIIF_COLLECTIONS_BASE_PATH=/path/to/your/collections
IIIF_SERVER_BASE_URL=https://iiif-content.crossasia.org/xasia/
FEDORA_BASE_URL=https://itr02.crossasia.org/fcrepo/rest
```

### 3. Run

```bash
java -jar target/iiifmanifestbuilders-1.0-SNAPSHOT.jar
```

Or use the main class:
```bash
java org.crossasia.manifest.IIIFManifestStart
```

## Input JSON Format

Each JSON file is converted into one IIIF Manifest. The JSON structure should include:

### Required Fields

- `id`: Unique identifier for the document
- `pages`: Array of page objects containing image information

### Example JSON Structure

```json
{
  "id": "document_001",
  "title": "Document Title",
  "pages": [
    {
      "position": "1",
      "name": "/path/to/image1.jpg",
      "label": "Page 1"
    },
    {
      "position": "2",
      "name": "/path/to/image2.jpg",
      "label": "Page 2"
    }
  ],
  "metadata": {
    "date": "2023",
    "author": "Author Name",
    "description": "Document description"
  }
}
```

## Supported Collections

The application currently supports the following collections, each with specific metadata schemas:

- **DTAB**: Tibetan Archives of the Berlin State Library
- **Kahlen**: Tangtong Gyalpo Archive Wolf Kahlen
- **TAP**: Tibetan and Himalayan Library
- **Turfan**: Turfan Collection from Museum für Asiatische Kunst
- **Sugawara**: Kashgar Contractual Documents Collection

## Output

For each input JSON file, the application generates:

- A IIIF Manifest JSON file with complete metadata
- Properly structured canvas objects for each page
- Thumbnail references
- Multi-language labels and metadata

Output manifests are saved to the collection-specific manifest folder (configurable).

## IIIF Image Server

The application integrates with IIIF Image API 2.1+ servers:

- **Default Server**: `https://iiif-content.crossasia.org/xasia/`
- **Image Info**: Automatically fetches dimensions from `/info.json` endpoints
- **Thumbnail Generation**: Creates thumbnail URIs for manifest display

## Configuration

### Application Properties

Edit `src/main/resources/application.properties`:

```properties
# Logging
logging.level.org.crossasia=DEBUG

# Collection paths
iiif.collections.base.path=/path/to/collections

# IIIF Server
iiif.server.base.url=https://iiif-content.crossasia.org/xasia/
```

### Collection-Specific Configuration

Collections are configured in `CollectionConfig.java`. To add a new collection:

1. Add an enum entry to `CollectionConfig`
2. Specify collection name, URLs, paths, and metadata schema
3. Optionally create a custom `AttributeProcessor` for collection-specific metadata

## Development

### Running Tests

```bash
mvn test
```

### Building

```bash
mvn clean package
```

### Code Structure

- `org.crossasia.manifest.canvas`: Canvas creation and page handling
- `org.crossasia.manifest.metadata`: Metadata extraction and building
- `org.crossasia.manifest.attributes`: Collection-specific attribute handlers
- `org.crossasia.manifest.statics`: Configuration and static resources
- `org.crossasia.manifest.transformation`: ID and data transformations

## Troubleshooting

### Common Issues

**No files found in directory**
- Check that `IIIF_COLLECTIONS_BASE_PATH` is set correctly
- Verify the collection result folder exists and contains JSON files

**Image dimensions not found**
- Verify IIIF server is accessible
- Check that image IDs match the server's expected format
- Review logs for specific URL errors

**JSON parsing errors**
- Validate JSON syntax using a JSON validator
- Ensure required fields (`id`, `pages`) are present
- Check for proper UTF-8 encoding

## Contributing

Contributions are welcome! Please:

1. Fork the repository
2. Create a feature branch
3. Add tests for new functionality
4. Ensure all tests pass
5. Submit a pull request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

The MIT License is a permissive free software license that allows anyone to:
- Use the software for any purpose
- Modify the software
- Distribute the software
- Include the software in proprietary products

The only requirement is that the license and copyright notice must be included in all copies or substantial portions of the software.

## Contact

**Project Maintainer:**
- Andrey Buchmann
- Email: Andrey.Buchmann@sbb.spk-berlin.de
- Institution: Staatsbibliothek zu Berlin - Preußischer Kulturbesitz

For questions, support, or collaboration inquiries, please contact the maintainer via email.