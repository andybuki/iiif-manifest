package org.crossasia.manifest.attributes.domain;

import java.util.List;

/**
 * Represents information about official seals found on historical documents.
 *
 * <p>Seals are important authenticating marks on historical documents, especially
 * in Asian administrative and legal documents. This class captures both physical
 * characteristics (color, form, size) and metadata (inscriptions, scripts, references).</p>
 *
 * <p>The class supports multiple seals per document, as documents may contain several
 * official seals from different authorities or time periods.</p>
 *
 * <h3>Physical Characteristics</h3>
 * <ul>
 *   <li><strong>Colors:</strong> Ink or stamp colors (e.g., "Red", "Black", "Blue")</li>
 *   <li><strong>Forms:</strong> Seal shapes (e.g., "Round", "Square", "Rectangular")</li>
 *   <li><strong>Sizes:</strong> Physical dimensions</li>
 *   <li><strong>Inscriptions:</strong> Text or symbols on the seal</li>
 * </ul>
 *
 * <h3>Example Usage</h3>
 * <pre>{@code
 * SealInfo seal = new SealInfo();
 * seal.setSealId("SEAL001");
 * seal.setColors(Arrays.asList("Red"));
 * seal.setForms(Arrays.asList("Round"));
 * seal.setInscriptions(Arrays.asList("Official Seal of the Dalai Lama"));
 * }</pre>
 *
 * @see org.crossasia.manifest.attributes.DtabAttributes
 */
public class SealInfo {
    /** Primary seal identifier */
    private String sealId;

    /** List of seal identifiers (when multiple seals present) */
    private List<String> sealIds;

    /** Primary seal name or description */
    private String seal;

    /** List of seal names or descriptions */
    private List<String> seals;

    // Physical characteristics

    /** Colors of the seal impressions (e.g., "Red", "Black") */
    private List<String> colors;

    /** Shapes/forms of the seals (e.g., "Round", "Square") */
    private List<String> forms;

    /** Physical sizes of the seals */
    private List<String> sizes;

    /** Text inscriptions or symbols on the seals */
    private List<String> inscriptions;

    // Metadata

    /** Names of scripts used in seal inscriptions (e.g., "Tibetan", "Chinese") */
    private List<String> nameOfScripts;

    /** Comments about the scripts used in seal inscriptions */
    private List<String> commentUsedScripts;

    /** Bibliographic or catalog references for the seals */
    private List<String> references;

    /** General comments about the seals */
    private List<String> comments;

    /** External links to additional seal information */
    private List<String> links;

    /** Paths or URLs to seal image files */
    private List<String> imageFiles;

    /** References to similar or comparable seals */
    private List<String> compare;

    // Document associations

    /** IDs of documents where these seals appear */
    private List<String> documentIds;

    /** Information about multiple seals on the same document */
    private List<String> multiSeal;

    /**
     * Default constructor.
     */
    public SealInfo() {}

    // Getters and setters
    public String getSealId() { return sealId; }
    public void setSealId(String sealId) { this.sealId = sealId; }

    public List<String> getSealIds() { return sealIds; }
    public void setSealIds(List<String> sealIds) { this.sealIds = sealIds; }

    public String getSeal() { return seal; }
    public void setSeal(String seal) { this.seal = seal; }

    public List<String> getSeals() { return seals; }
    public void setSeals(List<String> seals) { this.seals = seals; }

    public List<String> getColors() { return colors; }
    public void setColors(List<String> colors) { this.colors = colors; }

    public List<String> getForms() { return forms; }
    public void setForms(List<String> forms) { this.forms = forms; }

    public List<String> getSizes() { return sizes; }
    public void setSizes(List<String> sizes) { this.sizes = sizes; }

    public List<String> getInscriptions() { return inscriptions; }
    public void setInscriptions(List<String> inscriptions) { this.inscriptions = inscriptions; }

    public List<String> getNameOfScripts() { return nameOfScripts; }
    public void setNameOfScripts(List<String> nameOfScripts) { this.nameOfScripts = nameOfScripts; }

    public List<String> getCommentUsedScripts() { return commentUsedScripts; }
    public void setCommentUsedScripts(List<String> commentUsedScripts) {
        this.commentUsedScripts = commentUsedScripts;
    }

    public List<String> getReferences() { return references; }
    public void setReferences(List<String> references) { this.references = references; }

    public List<String> getComments() { return comments; }
    public void setComments(List<String> comments) { this.comments = comments; }

    public List<String> getLinks() { return links; }
    public void setLinks(List<String> links) { this.links = links; }

    public List<String> getImageFiles() { return imageFiles; }
    public void setImageFiles(List<String> imageFiles) { this.imageFiles = imageFiles; }

    public List<String> getCompare() { return compare; }
    public void setCompare(List<String> compare) { this.compare = compare; }

    public List<String> getDocumentIds() { return documentIds; }
    public void setDocumentIds(List<String> documentIds) { this.documentIds = documentIds; }

    public List<String> getMultiSeal() { return multiSeal; }
    public void setMultiSeal(List<String> multiSeal) { this.multiSeal = multiSeal; }
}